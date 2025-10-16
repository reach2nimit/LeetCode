import os
from fpdf import FPDF
import markdown
import html2text
import re

class PDF(FPDF):

    def add_problem(self, title, description, solution, difficulty="", tags=""):
        # Title
        self.set_font("Arial", "B", 12)
        self.multi_cell(0, 10, title)
        self.ln(1)

        # Tags (above description)
        if tags:
            self.set_font("Arial", "B", 10)
            self.set_text_color(0, 0, 128)  # Dark Blue
            tag_list = [tag.strip() for tag in tags.split(",")]
            formatted_tags = "   ".join(f"[{tag}]" for tag in tag_list)
            self.multi_cell(0, 5, f"Tags: {formatted_tags}")
            self.set_text_color(0, 0, 0)  # Reset color
            self.ln(2)

        # Description
        if description:
            self.set_font("Arial", "", 10)
            self.multi_cell(0, 5, description)
            self.ln(3)

        # Code solution
        if solution:
            self.set_font("Courier", "", 10)  # Increased font size
            self.set_fill_color(240, 240, 240)  # Light grey background
            self.set_text_color(0, 0, 0)  # Black text
            self.multi_cell(0, 5, solution, fill=True)  # Fill background
            self.ln(6)

def read_description(folder_path):
    import markdown
    import html2text
    import re

    readme_path = os.path.join(folder_path, "README.md")
    if not os.path.exists(readme_path):
        return ""

    with open(readme_path, "r", encoding="utf-8") as f:
        md_text = f.read()

    # Convert markdown to HTML, then to plain text
    html = markdown.markdown(md_text)
    full_text = html2text.html2text(html)

    # Define cutoff keywords where we stop collecting lines
    cutoff_keywords = [
        "example", "examples", "input", "output", "constraints", "custom judge"
    ]

    # Clean and extract only the problem statement
    lines = full_text.splitlines()
    statement_lines = []

    for line in lines:
        line = line.strip()
        lower = line.lower()

        # Skip markdown headings, difficulty lines, or decorative lines
        if (
            line.startswith("#")
            or "difficulty:" in lower
            or re.search(r"\)\s*\*+\s*$", line)  # e.g., ") ***"
            or set(line) <= {"*", " "}  # lines that are just asterisks or spaces
        ):
            continue

        # Stop collecting once cutoff keywords are hit
        if any(keyword in lower for keyword in cutoff_keywords):
            break

        # Remove markdown links: [text](url)
        line = re.sub(r"\[([^\]]+)\]\((.*?)\)", r"\1", line)

        # Remove raw URLs
        line = re.sub(r"http[s]?://\S+", "", line)

        if line:
            statement_lines.append(line)


    # Group lines into chunks of 2 and insert a newline between them
    chunked = [
        " ".join(statement_lines[i:i+2])
        for i in range(0, len(statement_lines), 2)
    ]
    description = "\n\n".join(chunked)

    # Final cleanup pass
    description = re.sub(r"\s*\(\s*[-\w]+\s*\)\s*", "", description)  # remove leftover slugs in parentheses
    description = re.sub(r"\*+", "", description)  # remove remaining asterisks
    description = re.sub(r"\s{2,}", " ", description)  # collapse extra spaces

    return description.strip()




def extract_solutions(base_folder):
    problems_by_topic = {}
    print(f"🔍 Searching in: {base_folder}")
    for root, dirs, files in os.walk(base_folder):
        for file in files:
            if file.endswith(".java"):
                filepath = os.path.join(root, file)

                topic_folder = os.path.basename(os.path.dirname(os.path.dirname(filepath)))
                problem_folder = os.path.basename(os.path.dirname(filepath))

                # folder_path = os.path.dirname(filepath)
                # folder_name = os.path.basename(folder_path)

                try:
                    num, slug = problem_folder.split("-", 1)
                    title = slug.replace("-", " ").title()
                    link = f"https://leetcode.com/problems/{slug}/"

                    # Read solution code
                    with open(filepath, "r", encoding="utf-8") as f:
                        code = f.read()

                    # Read description from README
                    description = read_description(os.path.dirname(filepath))

                    problem = {
                        "number": int(num),
                        "title": f"{num}. {title}",
                        "link": link,
                        "description": description,
                        "code": code
                    }

                    if topic_folder not in problems_by_topic:
                        problems_by_topic[topic_folder] = []

                    problems_by_topic[topic_folder].append(problem)
                    print(f"✅ Added: {num} - {title} under {topic_folder}")
                except Exception as e:
                    print(f"⚠️ Skipped {problem_folder}: {e}")
    return problems_by_topic


# ✅ Main function
def main():
    base_dir = "."  # Current directory
    problems = extract_solutions(base_dir)

    if not problems:
        print("❌ No solutions found.")
        return

    pdf = PDF()
    pdf.set_auto_page_break(auto=True, margin=10)
    pdf.add_page()

    pdf.set_font("Arial", "B", 16)
    pdf.cell(0, 10, "LeetCode Solutions", ln=True, align="C")
    pdf.ln(10)

    for folder_name in sorted(problems.keys()):
        pdf.set_font("Arial", "B", 14)
        pdf.set_text_color(0, 102, 0)
        pdf.cell(0, 10, f"======================== {folder_name.replace('-', ' ').title()} ======================== ", ln=True)
        print(f"this is the folder name to print ---> {folder_name}" )
        pdf.set_text_color(0, 0, 0)
        pdf.ln(4)

        for p in sorted(problems[folder_name], key=lambda x: x["number"]):
            pdf.add_problem(
                title=p["title"],
                description=p["description"],
                solution=p["code"],
                tags="",  # Add tags if available
            )


    output_path = "LeetCode-Solutions.pdf"
    pdf.output(output_path)
    print(f"\n✅ PDF created: {output_path}")

# ✅ Run script
if __name__ == "__main__":
    main()

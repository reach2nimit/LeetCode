struct Node{
public:
    Node * next;
    Node* prev;
    int key, value;
    Node(){
        this->key=0;
        this->value=0;
        this->next = NULL;
        this->prev= NULL;
    }
};

class LRUCache {
public:
    
    Node* head = new Node();
    Node* tail = new Node();
    unordered_map<int,Node*> nodeMap;
    int capacity;
    
    LRUCache(int capacity) {
    
        this->capacity=capacity;
        head->next = tail;
        tail -> prev = head;
    }
    
    int get(int key) {
        
        if(nodeMap.find(key)==nodeMap.end())
            return -1;
        Node* node = nodeMap[key];
        removeNode(node);
        addNode(node);
        return node->value;        
    }
    
    void put(int key, int value) {
        
        if(nodeMap.find(key)!=nodeMap.end()){
            Node *node = nodeMap[key];
            node->value = value;
            removeNode(node);
            addNode(node);
            return;
        }
        
        if (nodeMap.size()==capacity){
            Node* temp = tail->prev;
            removeNode(temp);
            nodeMap.erase(temp->key);
            delete temp;
        }
        
        Node* node = new Node();
        node->key = key;
        node->value=value;
        addNode(node);
        nodeMap[key]=node;
        
    }
    
    void addNode(Node* node){
        
        node->next = head->next;
        head->next->prev = node;
        head->next = node;
        node->prev = head;
        nodeMap[node->key]=node;
    }
    void removeNode(Node* node){
        node-> prev->next = node->next;
        node->next->prev = node -> prev;
    }
};


#include "Node.cpp"
class LinkList
{
private:
   /* data */
public:
   Node *head;

   LinkList(/* args */);

   ~LinkList();
   void apand(int x);
   void deleteNode(int x);
   void printList();
   void clearNode();
};

LinkList::LinkList(/* args */)
{
   head = nullptr;
}

LinkList::~LinkList()
{
   delete head;
}

LinkList::apand(int x ){
   Node* nextNode = new Node(x);
   if (head == nullptr)
   {
      head  = nextNode;
      
   } else{
      Node* current  =head;
      while (current->next != nullptr)
      {
         current = current->next;
      }
      current->next = nextNode;
      
   }
   
}
LinkList::deleteNode(int x){

}
LinkList::printList(){
   Node* next =  
}

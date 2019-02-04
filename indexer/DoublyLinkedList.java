 import java.util.*;
 
 public class DoublyLinkedList<E> 
 {
  //---------------- nested Node class ----------------
  
    private static class Node<E> {
		
		
		public static class Tags<E>
		{  
		int tagcount;  
		E tagname;
		
		public Tags(E name){  
		this.tagname=name;  
		this.tagcount=1  ;
		} 
		void increaseTcount()
		{
			tagcount++;
		} 
		E getTag()
		{
			return tagname;
		}
		int get_tagcount()
		{
			return tagcount;
		}
		}
																							
		
     private E file; // reference to the file stored at this node
	 private ArrayList<Tags<E>> aL;
    private Node<E> next; // reference to the subsequent node in the list
    private Node<E> prev;
    private int count;
    
    public Node(E e, Node<E> n,Node<E> p) 
    {
     file = e;
     next = n;
     prev=p;
     count =1;
	 aL=new ArrayList<Tags<E>>();
     }
     
    public E getFile( )
     { return file; }
     
     public Node<E> getNext( ) { return next; }
     public Node<E> getPrev( ) { return prev; }
     
     public void setNext(Node<E> n) { next = n; }
     public void setPrev(Node<E> p) { prev = p; }
	 
	 public void increaseCount()
	 {
		 count++;
	 }
	 
	 public void addTags(E tag)
	 { 
		Tags<E> t;
         for(int i=0;i<aL.size();i++)
		 {
			 t=aL.get(i);
			 if(tag.equals(t.getTag()))
			 {
				 t.increaseTcount();
				 tDisplay();
				 return;
			 }
		 }
		 Tags<E> temp=new Tags<E>(tag);
		 aL.add(temp);
         tDisplay();		 
     }
	 
	 void tDisplay()
	 {
		 for(int i=0;i<aL.size();i++)
		 {
			 System.out.println(aL.get(i).getTag()+" "+aL.get(i).get_tagcount());
		 }
     }
	}
	
	
    										//----------- end of nested Node class -----------
                                            // instance variables of the SinglyLinkedList
    										
    										
    										
    										
     
     private Node<E> head = null; // head node of the list (or null if empty)
     private Node<E> tail = null; // last node of the list (or null if empty)
     private int size = 0; // number of nodes in the list
     
     public DoublyLinkedList( ) { } // constructs an initially empty list
    // access methods
     public int size( ) { return size; }
    public boolean isEmpty( ) { return size == 0; }
    
     public E first( ) { // returns (but does not remove) the first file
     if (isEmpty( )) return null;
     return head.getFile( );
     }
     
     public E last( ) { // returns (but does not remove) the last file
     if (isEmpty( )) return null;
     return tail.getFile( );
     }
    
     // update methods
     public void addFirst(E file) { // adds file e to the front of the list
     head = new Node<E>(file, head,null); // create and link a new node
     if (size == 0)
     tail = head; // special case: new node becomes tail also
     else
     {
    	Node<E> t=head.getNext();
    	t.setPrev(head);
    }
     size++;
    }
    public void addLast(E e) 
	{ 										// adds file e to the end of the list
    
     Node<E> newest = new Node<E>(e, null,null); // node will eventually be the tail
     if (isEmpty( ))
     head = newest; // special case: previously empty list
     else
     {
         tail.setNext(newest); // new node after existing tail
    	 newest.setPrev(tail);
     }
     tail = newest; // new node becomes the tail
     size++;
     }
     
     public E removeFirst( ) 
	 { 								// removes and returns the first file
     if (isEmpty( )) return null; // nothing to remove
     E answer = head.getFile( );
     head = head.getNext( ); // will become null if list had only one node
     size--;
     if (size == 0)
       tail = null; // special case as list is now empty
     else
    	head.setPrev(null);
     return answer;
     }
     
     public E removeLast()
     {
    	 if(isEmpty())
    		 return null;
    	 E answer=tail.getFile();
    	 tail=tail.getPrev();
    	 size--;
    	 if(size==0)
    	 head=null;
        else
    		tail.setNext(null);
    	return answer;
     }
     
     public void display()
     {
    	 System.out.println();
    	 Node<E> t=head;
    	 if(t==null)
    		 System.out.println("empty queue");
    	 else
    	 {
    		 while(t!=null)
    		 {
    			 System.out.print(t.getFile()+" ");
    			 t=t.getNext();	 
    		 }
    		 System.out.println();
    	 }
     }
     
     void  addinDList(E file,E tag)
     {
		 int flag=0;
		 Node<E> t=head,p=null;
		 
    	 if(head==null)
		 {
			 addFirst(file);
			 p=head;
		 }
		else
		{
			while(t!=null)
			{
				if(t.getFile().equals(file))
				{
					t.increaseCount();
					p=t;
					flag=1;
					break;
				}
				t=t.getNext();
			}
			if(flag==0)
			{
				addLast(file);
				p=tail;
			}
     }
	 
	 p.addTags(tag);
     display();
   }   
}
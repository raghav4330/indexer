import java.util.*;
class BinarySearchTree<E>
{
	private static class Node<E>
	{
		private E element;
		private Node<E> left;
		private Node<E> right;
		private DoublyLinkedList<E> db;
		
		Node(E e,Node<E> n1,Node<E> n2)
		{
			element = e;
			left=n1;
			right=n2; 
			
			db=new DoublyLinkedList<E>();
		}
		
		public E getElement()
		{
			return element;
		}
		
		public void setLeft(Node<E> n)
		{
			left=n;
		}
		public void setRight(Node<E> n)
		{
			right=n;
		}
		
		public Node<E> getLeft()
		{
			return left;
		}
		public Node<E> getRight()
		{
			return right;
		}
		
		public DoublyLinkedList<E> getdb()
		{
			return db;
		}
	}                                                     //end of node class//
	
	
	
	 private Node<E> root = null;
	 private int size=0;
	 
	 public int size( )
	 { 
	      return size; 
	 }
	 
     public boolean isEmpty( ) 
	 { 
	 return size == 0;
	 }
	 
	 public void insert(E data,E file,E tag)
	 {
		 System.out.println("\nin bst\n");
		 Node<E> newnode = new Node<E>(data,null,null);
		 root=addinTree(root,newnode,file,tag);
		 disp(root);
	 }
	 
	 Node<E>  addinTree(Node<E> n,Node<E> newnode,E file,E tag)
	 {
		 DoublyLinkedList<E> dbl;
		 if(n==null)
		 {
			 n=newnode;
			 dbl=n.getdb();
			 dbl.addinDList(file,tag);
			 return n;
		 }
		 else
		 {
			 String str1=(String)n.getElement();
			 String str2=(String)newnode.getElement();
			 
			 if(str1.compareTo(str2)>0)
			 {
				Node<E> t = addinTree(n.getLeft(),newnode,file,tag);
				n.setLeft(t);
				 return n;
			 }
			 else if(str1.compareTo(str2)<0)
			{
				Node<E> t = addinTree(n.getRight(),newnode,file,tag);
				n.setLeft(t);
				 return n;
				 //root= addinTree(n.right,newnode,file,tag);
				 //return n;
			 }
			 else
			 {
				 dbl=n.getdb();
				 dbl.addinDList(file,tag);
				 return n;
			 }
		 }
	 }
	 
	 void display()
	 {
		 disp(root);
	 }
	 
	 void disp(Node<E> n)
	 {
		 if(n!=null)
		 {
			 disp(n.left);
			 System.out.println(n.getElement());
			 disp(n.right);
		 }
	 }
			 
			
}
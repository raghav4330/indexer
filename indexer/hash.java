import java.util.*;

class Hash<E>
{
	int size;
	int key;
	BinarySearchTree<E> bst;
	ArrayList<BinarySearchTree<E>> aL;
	
	Hash(int size)
	{
		this.aL=new ArrayList<BinarySearchTree<E>>();
		for(int i=0;i<size;i++)
			aL.add(new BinarySearchTree<E>());
		this.size=size;
	}
	
	void insert(E data,E file,E tag)
	{
		key=getKey(data);
		(aL.get(key)).insert(data,file,tag);
	}
	
	int getKey(E data)
	{
		int k= (data.hashCode())%size;
		System.out.println(data+" "+k);
		if(k<0)
			k=-k;
		return k;
	}
	
}
package greatlearning.dsa.com;
class Node{
	int data;
	Node left, right;
	Node(int val){
		data=val;
		left=right=null;
	}
}
public class SumBST {
	Node root;
	SumBST(){
		root=null;
	}
	void insert(int key) { root = insertRec(root, key); }
	 Node insertRec(Node root, int data)
	    {
	 

	        /* If the tree is empty, return a new node */
	        if (root == null) {
	            root = new Node(data);
	            return root;
	        }
	 
	        /* Otherwise, recur down the tree */
	        if (data < root.data)
	            root.left = insertRec(root.left, data);
	        else if (data > root.data)
	            root.right = insertRec(root.right, data);
	 
	        return root;
	    }
	   
	    boolean isPairPresent(Node root, Node temp, int target)
	    {
	        if (temp == null)
	            return false;
	 
	        return search(root, temp, target - temp.data)
	            || isPairPresent(root, temp.left, target)
	            || isPairPresent(root, temp.right, target);
	    }
	 
	    boolean search(Node root, Node temp, int k)
	    {
	 
	        if (root == null)
	            return false;
	 
	        Node c = root;
	        boolean flag = false;
	        while (c != null && flag != true) {
	            if (c.data == k && temp != c) {
	                flag = true;
	                System.out.println("Pair Found: " + c.data
	                                   + " + " + temp.data);
	                return true;
	            }
	            else if (k < c.data)
	                c = c.left;
	            else
	                c = c.right;
	        }
	 
	        return false;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SumBST tree = new SumBST();
		 
		 /*
		  * 
		  * as per question BST 
		  *   	 /*
                   4
                /     \
              2        6
             / \     /  \
            1   3    5   7   
		 
		 	tree.insert(4);
	        tree.insert(2);
	        tree.insert(6);
	        tree.insert(1);
	        tree.insert(3);
	        tree.insert(5);
	        tree.insert(7);  
	        
	        
	        so as per given BST desired sum of 130 can't be found 
	        */
		 
		 /*
		  * 
		  * as per question BST 
		  *   	 /*
                  20
                /     \
              10      30
             / \     /  \
            9   60  25   70  */
		 
		 	tree.insert(20);
	        tree.insert(10);
	        tree.insert(30);
	        tree.insert(9);
	        tree.insert(60);
	        tree.insert(25);
	        tree.insert(70);  
	        
	 
	        boolean test= tree.isPairPresent(tree.root, tree.root, 130);
	        if (!test)
	            System.out.println("No such values are found!");
	     
	}

}

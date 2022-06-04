
public class LinkedGrid {
	private Node root;
	private int dimension;
	public LinkedGrid(int dimension) {
		this.dimension=dimension;
		//top left corner

		root=new Node();
		Node columnMarker=root;
		Node rowMarker=root;
		
		for(int x=0;x<dimension-1;x++) {
			columnMarker.setRight(new Node());
			columnMarker.getRight().setLeft(columnMarker);
			columnMarker=columnMarker.getRight();
		}
		for(int y=0;y<dimension-1;y++) {
			rowMarker.setDown(new Node());
			columnMarker=rowMarker.getDown();
			columnMarker.setUp(rowMarker);
			for(int x=0;x<dimension-1;x++) {
				Node temp=new Node();
				columnMarker.setRight(temp);
				temp.setLeft(columnMarker);
				temp.setUp(columnMarker.getUp().getRight());
				temp.getUp().setDown(temp);
				columnMarker=temp;
			}
			rowMarker=rowMarker.getDown();
		}
		
		Node temp=root;
		rowMarker=root;
		while(rowMarker!=null) {
			temp=rowMarker;
		while(temp!=null) {
			temp.setOpenpaths();
			if(temp.getUp()!=null&&temp.getUp().getUp()!=null&&temp.getUp().getUp().getRight()!=null) {
				temp.setPath1(temp.getUp().getUp().getRight());
				temp.setOpenpaths(temp.getOpenpaths()+1);
			}
			if(temp.getUp()!=null&&temp.getUp().getUp()!=null&&temp.getUp().getUp().getLeft()!=null) {
				temp.setPath2(temp.getUp().getUp().getLeft());
				temp.setOpenpaths(temp.getOpenpaths()+1);
			}
			if(temp.getUp()!=null&&temp.getUp().getRight()!=null&&temp.getUp().getRight().getRight()!=null) {
				temp.setPath3(temp.getUp().getRight().getRight());
				temp.setOpenpaths(temp.getOpenpaths()+1);
			}
			if(temp.getUp()!=null&&temp.getUp().getLeft()!=null&&temp.getUp().getLeft().getLeft()!=null) {
				temp.setPath4(temp.getUp().getLeft().getLeft());
				temp.setOpenpaths(temp.getOpenpaths()+1);
			}
			if(temp.getDown()!=null&&temp.getDown().getDown()!=null&&temp.getDown().getDown().getRight()!=null) {
				temp.setPath5(temp.getDown().getDown().getRight());
				temp.setOpenpaths(temp.getOpenpaths()+1);
			}
			if(temp.getDown()!=null&&temp.getDown().getDown()!=null&&temp.getDown().getDown().getLeft()!=null) {
				temp.setPath6(temp.getDown().getDown().getLeft());
				temp.setOpenpaths(temp.getOpenpaths()+1);
			}
			if(temp.getDown()!=null&&temp.getDown().getRight()!=null&&temp.getDown().getRight().getRight()!=null) {
				temp.setPath7(temp.getDown().getRight().getRight());
				temp.setOpenpaths(temp.getOpenpaths()+1);
			}
			if(temp.getDown()!=null&&temp.getDown().getLeft()!=null&&temp.getDown().getLeft().getLeft()!=null) {
				temp.setPath8(temp.getDown().getLeft().getLeft());
				temp.setOpenpaths(temp.getOpenpaths()+1);
				}
			temp=temp.getRight();
		}
		rowMarker=rowMarker.getDown();
		}
		
	}
	public void display() {
		Node temp;
		Node rowMarker=root;
		
		while(rowMarker!=null) {
			temp=rowMarker;
			
		while(temp!=null) {
			if(temp.getData()<10)
				System.out.print(" "+temp.getData()+" ");
			else
				System.out.print(temp.getData()+" ");
			temp=temp.getRight();
		}
		System.out.println();
		rowMarker=rowMarker.getDown();
		}
		System.out.println();
		/* //path testing
		System.out.println();
		temp=root;
		rowMarker=root;
		while(rowMarker!=null) {
			temp=rowMarker;
			
		while(temp!=null) {
			System.out.println("Node: "+temp.getData());
			if(temp.getPath1()!=null)
				System.out.println("Path 1: "+temp.getPath1().getData());
			if(temp.getPath2()!=null)
				System.out.println("Path 2: "+temp.getPath2().getData());
			if(temp.getPath3()!=null)
				System.out.println("Path 3: "+temp.getPath3().getData());
			if(temp.getPath4()!=null)
				System.out.println("Path 4: "+temp.getPath4().getData());
			if(temp.getPath5()!=null)
				System.out.println("Path 5: "+temp.getPath5().getData());
			if(temp.getPath6()!=null)
				System.out.println("Path 6: "+temp.getPath6().getData());
			if(temp.getPath7()!=null)
				System.out.println("Path 7: "+temp.getPath7().getData());
			if(temp.getPath8()!=null)
				System.out.println("Path 8: "+temp.getPath8().getData());
			System.out.println();
			temp=temp.getRight();
		}
		System.out.println();
		rowMarker=rowMarker.getDown();
		}
		*/
		 
		
	}
	public void tour()throws Exception {
		tour(root,1);
	}
	public void tour(Node n,int step) throws Exception{
		
		n.setData(step);
		//display();
		int zeroLinkedPath=0;
		Node zeroLinked = null;
	if(n.getPath1()!=null){
		n.getPath1().setOpenpaths(n.getPath1().getOpenpaths()-1);
		if(n.getPath1().getOpenpaths()==0) {
			zeroLinkedPath++;
			zeroLinked=n.getPath1();
			}
	}
	if(n.getPath2()!=null){
		n.getPath2().setOpenpaths(n.getPath2().getOpenpaths()-1);
		if(n.getPath2().getOpenpaths()==0) {
			zeroLinkedPath++;
			zeroLinked=n.getPath2();
		}
	}
	if(n.getPath3()!=null){
		n.getPath3().setOpenpaths(n.getPath3().getOpenpaths()-1);
		if(n.getPath3().getOpenpaths()==0) {
			zeroLinkedPath++;
			zeroLinked=n.getPath3();
		}
	}
	if(n.getPath4()!=null){
		n.getPath4().setOpenpaths(n.getPath4().getOpenpaths()-1);
		if(n.getPath4().getOpenpaths()==0) {
		zeroLinkedPath++;
		zeroLinked=n.getPath4();
		}
	}
	if(n.getPath5()!=null){
		n.getPath5().setOpenpaths(n.getPath5().getOpenpaths()-1);
		if(n.getPath5().getOpenpaths()==0) {
			zeroLinkedPath++;
			zeroLinked=n.getPath5();
		}
	}
	if(n.getPath6()!=null){
		n.getPath6().setOpenpaths(n.getPath6().getOpenpaths()-1);
		if(n.getPath6().getOpenpaths()==0) {
			zeroLinkedPath++;
			zeroLinked=n.getPath6();
		}
	}
	if(n.getPath7()!=null){
		n.getPath7().setOpenpaths(n.getPath7().getOpenpaths()-1);
		if(n.getPath7().getOpenpaths()==0) {
			zeroLinkedPath++;
			zeroLinked=n.getPath7();
		}
	}
	if(n.getPath8()!=null){
		n.getPath8().setOpenpaths(n.getPath8().getOpenpaths()-1);
		if(n.getPath8().getOpenpaths()==0) {
			zeroLinkedPath++;
			zeroLinked=n.getPath8();
		}
	}
		if(step==dimension*dimension) {
			display();
			n.setData(0);
			}
	if(zeroLinkedPath<2) {	
		if(zeroLinkedPath!=0) {
			if(zeroLinked!=null&&zeroLinked.getData()==0)
				tour(zeroLinked,step+1);
		}
		if(n.getPath1()!=null&&n.getPath1().getData()==0) {
			n.setOpenpaths(n.getOpenpaths()-1);
		//	n.getPath1().setOpenpaths(n.getPath1().getOpenpaths()-1);
			tour(n.getPath1(),step+1);
			
		}
		if(n.getPath2()!=null&&n.getPath2().getData()==0){
				n.setOpenpaths(n.getOpenpaths()-1);
			//	n.getPath2().setOpenpaths(n.getPath2().getOpenpaths()-1);
				tour(n.getPath2(),step+1);
			}
		if(n.getPath3()!=null&&n.getPath3().getData()==0){
				n.setOpenpaths(n.getOpenpaths()-1);
			//	n.getPath3().setOpenpaths(n.getPath3().getOpenpaths()-1);
				tour(n.getPath3(),step+1);
			}
		if(n.getPath4()!=null&&n.getPath4().getData()==0){
				n.setOpenpaths(n.getOpenpaths()-1);
			//	n.getPath4().setOpenpaths(n.getPath4().getOpenpaths()-1);
				tour(n.getPath4(),step+1);
				}
		if(n.getPath5()!=null&&n.getPath5().getData()==0){
				n.setOpenpaths(n.getOpenpaths()-1);
			//	n.getPath5().setOpenpaths(n.getPath5().getOpenpaths()-1);
				tour(n.getPath5(),step+1);
			}
		if(n.getPath6()!=null&&n.getPath6().getData()==0){
				n.setOpenpaths(n.getOpenpaths()-1);
			//	n.getPath6().setOpenpaths(n.getPath6().getOpenpaths()-1);
				tour(n.getPath6(),step+1);
				}
		if(n.getPath7()!=null&&n.getPath7().getData()==0){
				n.setOpenpaths(n.getOpenpaths()-1);
			//	n.getPath7().setOpenpaths(n.getPath7().getOpenpaths()-1);
				tour(n.getPath7(),step+1);
			}
				
		if(n.getPath8()!=null&&n.getPath8().getData()==0){
				n.setOpenpaths(n.getOpenpaths()-1);
			//	n.getPath8().setOpenpaths(n.getPath8().getOpenpaths()-1);
				tour(n.getPath8(),step+1);
				}
		
	}
		n.setData(0);
		
	}
		
		
		
	
	

	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public int getDimension() {
		return dimension;
	}
	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
}

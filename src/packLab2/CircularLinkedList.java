package packLab2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<T> implements ListADT<T> {

	// Atributuak
	protected Node<T> last; // azkenaren erreferentzia
//	private Node<T> current; //lantzen ari garen nodoa
	protected String deskr;  // deskribapena
	protected int count;

	public CircularLinkedList() {
		last = null;
		deskr = "";
		count = 0;
	}
	
	public void setDeskr(String ize) {
	  deskr = ize;
	}

	public String getDeskr() {
	  return deskr;
	}

	public T removeFirst() {
	// listako lehen elementua kendu da
	// Aurrebaldintza: zerrenda ez da hutsa
		// KODEA OSATU ETA KOSTUA KALKULATU
		T emaitza=null;
		if (this.isEmpty()==false) {
			if (last.next==last) {
				emaitza=last.data;
				count = 0;
				last=null;
			}else {
				emaitza=last.next.data;
				last.next=last.next.next;
				count --;
			}
		}
		
		return emaitza;
	}

	public T removeLast() {
	// listako azken elementua kendu da
	// Aurrebaldintza: zerrenda ez da hutsa
		// KODEA OSATU ETA KOSTUA KALKULATU
		T emaitza=null;
		if (this.isEmpty()==false) {
			if (last.next==last) {
				emaitza=last.data;
				count = 0;
				last=null;
			}else {
				Node<T> current=last.next;
				while (current.next!=last) {
					current=current.next;
				}
				emaitza=current.next.data;
				current.next=last.next;
				count --;
			}
		}
		return emaitza;
    }


	public T remove(T elem) {
	// Aurrebaldintza: zerrenda ez da hutsa
	// Balio hori listan baldin badago, bere lehen agerpena ezabatuko dut. Kendutako objektuaren erreferentzia 
        //  bueltatuko du (null ez baldin badago)
	
		// KODEA OSATU ETA KOSTUA KALKULATU
		T emaitza=null;
		boolean aurkituta=false;
		Node<T> current=last.next;
		if (this.isEmpty()==false) {
			if (last.next==last && last.data==elem) {
				emaitza=elem;
				last=null;
			} else {
				while (!aurkituta || current!=last) {
					if (current.next.data==elem) {
						if (current.next==last) {
							current.next=last.next;
						} else if (current.next==last.next) {
							last.next=last.next.next;
						}
						emaitza=elem;
						aurkituta=true;
					}
				}
			}
		}			//EKAITZ: TENGO QUE REVISAR EL CODIGO
		return emaitza;
        };

	public T first() {
	// listako lehen elementua ematen du
	      if (isEmpty())
	          return null;
	      else return last.next.data;
	}

	public T last() {
	// listako azken elementua ematen du
	      if (isEmpty())
	          return null;
	      else return last.data;
	}

	public boolean contains(T elem) {
	// Egiazkoa bueltatuko du aurkituz gero, eta false bestela
		return (this.find(elem)!=null);
	}

	public T find(T elem) {
	// Elementua bueltatuko du aurkituz gero, eta null bestela
		
		// KODEA OSATU ETA KOSTUA KALKULATU
		T emaitza=null;
		if (this.isEmpty()==false) {
			if (elem==last.data) {
				emaitza=elem;
			} else {
				Node<T> current = last.next;
				boolean aurkitua=false;
				while (!aurkitua || current!=last) {
					if (current.data==elem) {
						emaitza=elem;
						aurkitua=true;
					}
					current=current.next;
				}
			}
		}
		return emaitza;
	}

	public boolean isEmpty() 
	{ return last == null;}
	
	public int size() 
	{ return count;}
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		} 
		   

		// KODEA OSATU 
	   } // private class
		
		
		public void adabegiakInprimatu() {
			System.out.println(this.toString());
		}

		
		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "SimpleLinkedList " + result + "]";
		}
		

}

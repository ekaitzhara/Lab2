package packLab2;

public interface UnorderedListADT<T> extends ListADT<T> {

	public void addToFront(T elem); // elementua gehitzen du hasieran
	public void addToRear(T elem); // elementua gehitzen du hasieran
	public void addAfter(T elem, T target); // elementua gehitzen du target elementuaren ondoren (target zerrendan dago)
}

package site.part.ms.service;

public interface PaginationAdapter<T> {
	/*
	 * public int current = 0; public int count=10; default int getCurrent() {
	 * return current; } default int getCount() { return count; } default void
	 * setCurrent(int current) {}; default void setCount(int count) {};
	 */
	public T nextPage();
	public T previousPage();
	public T currentPage();
}

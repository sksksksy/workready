package site.tj.program.service;

import java.util.List;

public interface ProgramOperation {
	default List<?> queryBy() {return null;};
}
package site.tj.program.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class TableResponse {
	@Getter @Setter private String msg;
	@Getter @Setter private String tip;
	@Getter @Setter private List<?> tdata;
	@Getter @Setter private List<String> thead;
}

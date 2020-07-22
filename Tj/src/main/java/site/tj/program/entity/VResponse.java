package site.tj.program.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class VResponse {
	@Getter @Setter private String msg;
	@Getter @Setter private List<?> vdata;
}

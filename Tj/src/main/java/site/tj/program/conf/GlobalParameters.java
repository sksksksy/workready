package site.tj.program.conf;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class GlobalParameters {
	@Getter @Setter private int EmplyeesCount=0;
	@Getter @Setter private int DayRecordsCount=0;
	@Getter @Setter private int EmplyeesRecordCount=0;
	@Getter @Setter private int WorkProgramsCount=0;
}

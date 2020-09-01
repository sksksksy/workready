package site.part.ms.struct;

import lombok.Getter;
import lombok.Setter;
import site.part.ms.entity.DirTable;

import java.util.List;

public class DirStruct {
    @Getter @Setter
    private DirTable dirTable;
    @Getter @Setter
    private DirStruct dirStruct;
    @Getter @Setter
    private List<DirTable> list;
}

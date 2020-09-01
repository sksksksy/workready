package site.part.ms.entity;

import lombok.Getter;
import lombok.Setter;

public class DirTable {
    @Getter @Setter private Integer dirId;
    @Getter @Setter private Integer parentDirId;
    @Getter @Setter private String dirName;
    DirTable(){}
    public DirTable(Integer dirId, Integer parentDirId, String dirName) {
        this.dirId = dirId;
        this.parentDirId = parentDirId;
        this.dirName = dirName;
    }

    @Override
    public String toString() {
        return "DirTable{" +
                "dirId=" + dirId +
                ", parentDirId=" + parentDirId +
                ", dirName='" + dirName + '\'' +
                '}';
    }
}

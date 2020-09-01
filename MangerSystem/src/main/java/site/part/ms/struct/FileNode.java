package site.part.ms.struct;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FileNode {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private List<FileNode> fileNodes;
    public FileNode(){
//        fileNodes= Collections.emptyList();
    }
    public FileNode(String name){
        this.name=name;
//        fileNodes= Collections.emptyList();
    }
    public void append(FileNode fileNode){
        if(fileNodes==null||fileNodes.isEmpty()){
            fileNodes=new LinkedList<>();
        }
        fileNodes.add(fileNode);
    }

}

package site.part.ms.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.part.ms.entity.DirTable;
import site.part.ms.mapper.DirTableMapper;
import site.part.ms.struct.DirStruct;
import site.part.ms.struct.FileNode;

import javax.annotation.Resource;
import java.util.*;

@Service
public class DirTableService {
    Map<String,Object> temp=new LinkedHashMap<>();
    List<DirTable> lst=new LinkedList<>();
    DirStruct dd=new DirStruct();
    @Resource
    private DirTableMapper dirTableMapper;
    @Transactional(readOnly = true)
    public Object getDirs(Integer dirId){
       /* Map<String,Object> json=new LinkedHashMap<>();
        json.put("current",getDir(dirId));
        Object temp=null;
        Map<String,Object> mid=new LinkedHashMap<>();
        Object subs=gets(dirId,mid,1);*/
//        Map<String,Object> json=new LinkedHashMap<>();
        FileNode root=new FileNode("Root");
        getAllDir(dirId,root);
        return root;
    }
    Object gets(Integer id,Map mid,Integer level){
        List<DirTable> t=getSubDirs(id);
        DirTable dt=getDir(id);
        if(t.isEmpty()){
            mid.put(dt.getDirName(),t);
            return mid;
        }
        for(DirTable dir:t){
            Map<String,Object> tt=new LinkedHashMap<>();
            Object o=gets(dir.getDirId(),mid,level++);
            tt.put(dir.getDirName(),o);
            mid.put(dt.getDirName(),tt);
        }
        return mid;
    }
    public List<DirTable> getSubDirs(Integer id){
        List<DirTable> result=dirTableMapper.getSubDirs(id);
        if(result==null){
            result= Collections.emptyList();
        }
//        System.out.println(result.get(0).getDirName());
        return result;
    }
    public DirTable getDir(Integer id){
        DirTable dirTable=dirTableMapper.getDir(id);
        return dirTable;
    }
    boolean isNull(Object o){
        return o==null;
    }
    public void getAllDir(Integer id, FileNode node){
        List<DirTable> t=getSubDirs(id);
        DirTable dt=getDir(id);
        node.setName(dt.getDirName());
        if(t.isEmpty()||t==null){
            return;
        }
        for(DirTable d:t){
            int a=d.getDirId();
            FileNode fNode=new FileNode(d.getDirName());
            node.append(fNode);
            if(a>0){
                getAllDir(a,fNode);
            }
        }
    }
}

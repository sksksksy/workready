//package site.tj.program.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
//import site.tj.program.entity.DayRecords;
//import site.tj.program.service.DayRecordRepository;
//
//import java.util.List;
//
//
//public class searchServer {
//    @Autowired
//    private DayRecordRepository dayRecordRepository;
//    public void save(){
//        DayRecords dayRecords=new DayRecords();
//        dayRecordRepository.save(dayRecords);
//    }
//    public List<DayRecords> search(){
//        Pageable page= PageRequest.of(1,10);
//        DayRecords d=new DayRecords();
////        NativeSearchQuery searchQuery= new NativeSearchQueryBuilder().withQuery(queryStringQuery("")).withPageable(page).build();
//        Page<DayRecords> dayRecords=dayRecordRepository.searchSimilar(d,new String[]{""},page);
//
//        return dayRecords.getContent();
//    }
//}

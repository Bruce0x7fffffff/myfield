package com.baseweb.myfield.esDemo.controller;


        import com.baseweb.myfield.esDemo.dao.BookDao;
        import com.baseweb.myfield.esDemo.entity.Book;
        import org.elasticsearch.index.query.QueryStringQueryBuilder;
        import org.springframework.beans.BeanUtils;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookDao bookDao;

    /**
     * 1、新增
     * @param book
     * @return
     */
    @PostMapping("/insert")
    public Book insertBook(@RequestBody  Book book) throws Exception {
        if(book == null){
            throw new Exception("boot 为空");
        }
        bookDao.save(book);
        return book;
    }
    /**
     * 2、查 通过id
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookDao.findOne(id);
    }
    /**
     * 3、查  通过其他属性++:全文检索（根据整个实体的所有属性，可能结果为0个）
     * @param q
     * @return
     */
    @GetMapping("/select/{q}")
    public List<Book> testSearch(@PathVariable String q) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(q);
        Iterable<Book> searchResult = bookDao.search(builder);
        Iterator<Book> iterator = searchResult.iterator();
        List<Book> list = new ArrayList<Book>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    /**
     * 4、更新数据，通过id
     * @param book
     * @return
     */
    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        bookDao.save(book);
        return book;
    }
    /**
     * 5、删 通过id
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Book insertBook(@PathVariable String id) {
        Book book = bookDao.findOne(id);
        bookDao.delete(id);
        return book;
    }
}

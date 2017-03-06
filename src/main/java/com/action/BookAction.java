package com.action;

import com.entity.dao.BookDAO;
import lombok.Data;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component("bookaction")
public class BookAction {
    private int id;
    @Autowired
    private BookDAO bookdao;
    public String execute(){
        ServletActionContext.getContext().put("books",bookdao.query());
        return "success";
    }

    public String del(){
        bookdao.deleteById(id);
        return "success";
    }
}

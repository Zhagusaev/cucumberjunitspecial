package Pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Posts {


   private String title;
   private String content;
   private String status;

    public Posts(String title, String content, String status){
        this.content=content;
        this.status=status;
        this.title=title;
    }

    @Override
    public String toString(){
        return "This is the title "+this.title+ " this is the content "+this.content+ " this is the status "+this.status;
    }



}

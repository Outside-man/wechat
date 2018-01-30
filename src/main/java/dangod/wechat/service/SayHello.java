package dangod.wechat.service;


import dangod.wechat.core.annotation.Key;
import dangod.wechat.core.annotation.Text;
import dangod.wechat.core.service.BaseEventService;

@Text
@Key("hello")
public class SayHello implements BaseEventService {
    public String test(){
        System.out.println("做了一些微小的工作");
        return "hello";
    }
    @Override
    public String toString(){
        return test();
    }

    public SayHello(){

    }
}

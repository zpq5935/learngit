package zpq.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zpq.service.impl.TestService;

@RequestMapping("/hello")
@RestController
@Api(value = "hello类")
public class HelloController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired()
    private TestService testService;


    @ApiOperation(value = "测试hello方法", notes = "没什么特别的意思")
    @RequestMapping(value = "/{name}")
    public String hello(@PathVariable String name) {

        log.trace("trace");
        log.debug("debug");
        log.info("{} 你好", name);
        log.info("info");
        log.warn("warn");
        log.error("error");

        return "Hello World " + name;
    }
}

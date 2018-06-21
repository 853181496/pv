package controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
public class TestController {

    public void test(HttpServletRequest req, HttpServletResponse resp){
        try {
            String result = null;
            URL url = new URL("");
            URLConnection connection = url.openConnection();
            connection.connect();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
            PrintWriter writer = resp.getWriter();
            writer.print("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/test/data")
    public void testData(HttpServletRequest req,HttpServletResponse resp){
        JSONArray jsonArray = new JSONArray();
        for(int i=0;i<30;i++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("date","05-"+i);
            jsonObject.put("a",100+i*10);
            jsonObject.put("b",50+i);
            jsonArray.add(jsonObject);
        }
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
            writer.print(jsonArray.toString());
            writer.close();
        } catch (IOException e) {
            writer.close();
            e.printStackTrace();
        }
    }
    @RequestMapping("/test/load")
    public void load(HttpServletRequest req,HttpServletResponse resp){
        Random random = new Random();
//        req.setAttribute("power",random.nextInt(50)%(50-10+1)+10);
//        req.setAttribute("carbon",random.nextInt(50)%(50-10+1)+10);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        String format = simpleDateFormat.format(new Date());
//        req.setAttribute("time",format);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("power",random.nextInt(50)%(50-10+1)+10);
        jsonObject.put("carbon",random.nextInt(50)%(50-10+1)+10);
        jsonObject.put("time",format);
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
            writer.print(jsonObject.toString());
            writer.close();
        } catch (IOException e) {
            writer.close();
            e.printStackTrace();
        }
    }
//@GetMapping("/test/index")
    @RequestMapping("/pv/data")
    public ModelAndView test(ModelAndView mv,HttpServletRequest req) {
        mv.setViewName("/docs/demo1");
        Random random = new Random();
        req.setAttribute("power",random.nextInt(50)%(50-10+1)+10);
        req.setAttribute("carbon",random.nextInt(50)%(50-10+1)+10);
        mv.addObject("title","欢迎使用Thymeleaf!");
        return mv;
    }
    @RequestMapping("/")
    public ModelAndView home(ModelAndView mv){
        mv.setViewName("/docs/home");
        return mv;
    }
    @RequestMapping("/pv/interAction")
    public ModelAndView interAction(ModelAndView mv){
        mv.setViewName("/docs/interAction");
        return mv;
    }
    public String index(HttpServletRequest req){
//        ModelAndView view = new ModelAndView("demo");
//        return view;
        return "a";
    }
//    @RequestMapping("/static/docs/demo.html")
//    public String index1(HttpServletRequest req){
//        System.out.print("111111");
//        return "demo";
//    }
}

package org.server;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;
import org.json.JSONObject;
import persistence.Job;
import persistence.JobService;
import persistence.SchoolService;

public class Main implements Runnable{

    int PORT = 7000;
    SchoolService schools ;
    JobService Jobs ;
    Javalin server ;
    public static void main(String[] args) {
        Main api = new Main().initialise();
        api.run();

    }


    public void startServer(){
        server.start("192.168.1.107",PORT);
    }

    public void stopServer(){
        server.stop();
    }

    @Override
    public void run(){
        startServer();
    }

     Main initialise(){
        this.server = initHTTPServer();
        this.schools = initSchools();
        this.Jobs = initJobs();
        return this;
    }

    public SchoolService initSchools(){
        return new SchoolService();
    }
    public JobService initJobs(){
        return new JobService();
    }

    public Javalin initHTTPServer(){
        Javalin app =  Javalin.create(javalinConfig -> {
            javalinConfig.enableCorsForAllOrigins();
        });


                app.get("/jobs/{place}",this::getJobs);
                app.get("/jobs",this::getAllJobs);
                app.get("/schools",this::getSchools);
                return app;
    }

    public void getJobs(Context context){
        context.json(Jobs.getJobsByLocation(context.pathParam("place")));
    }

    public void getAllJobs(Context context){
        JSONObject json = new JSONObject();
        ObjectMapper objectMapper = new ObjectMapper();
        Jobs.getJobs().forEach(job -> {
            try {
                json.put(job.getTitle(),objectMapper.writeValueAsString(job));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
        context.json(json.toMap());
    }

    public void getSchools(Context context){
        context.json(schools.getSchoolsByLocationAndInterest());
    }

}
//curl get "http://localhost:7000/jobs"


package org.server;


import io.javalin.Javalin;
import io.javalin.http.Context;
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
        server.start("192.168.1.100",PORT);
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
        return Javalin.create().get("/jobs/{place}",this::getJobs).get("/jobs",this::getAllJobs).get("/schools",this::getSchools);
    }

    public void getJobs(Context context){
        context.json(Jobs.getJobsByLocation(context.pathParam("place")));
    }

    public void getAllJobs(Context context){
        context.json(Jobs.getJobs());
    }

    public void getSchools(Context context){
        context.json(schools.getSchoolsByLocationAndInterest());
    }

}
//curl get "http://localhost:7000/jobs"


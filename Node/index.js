const express = require("express")
var url = require("url");
const axios = require('axios');
var bodyParser = require('body-parser');
const app = express()
app.set("view engine", "ejs")
app.use(bodyParser.urlencoded({ extended: false }));
app.get("/", function(req, res){
    res.render("home")
});
app.get("/add", function(req, res){
    res.render("addemp")
});
app.post("/add",function(req,res) {
    const EmployeeData =
    {
        "empid": req.body.empid,
        "empName": req.body.empName,
        "empRole": req.body.empRole,
        "empMail": req.body.empMail,
        "empContact": req.body.empContact
    }
       const AddEmployee = async () => {
           const response = await axios.post('http://myapp:8888/Emp/add',EmployeeData)
           res.send(response.data);
         }
         AddEmployee()
   });

   app.get("/getById", function(req, res){
    res.render("getByIdemp")
});

app.post("/getById",function(req,res) {
    const Emp_Id = req.body.empid;
    const getEmployeeDetails = async () => {
        const response = await axios.post('http://myapp:8888/Emp/getEmp/'+Emp_Id);
        var data=response.data
        if(data == null)
        {res.send("<h1>Employee Details</h1>"+"Employee Details Of Id "+Emp_Id+" Not Found") }
        else{
  var data1="<h1>Employee Details</h1>"
         +  JSON.stringify({"Employee Id ":data.empid})+"<br>"+
            JSON.stringify({"Employee Name ":data.empName})+"<br>"+
            JSON.stringify({"Employee Mail ":data.empMail})+"<br>"+
            JSON.stringify({"Employee Role ":data.empRole})+"<br>"+
            JSON.stringify({"Employee Contact ":data.empContact})

      res.send(data1.replace(/[^\w<>/:@.\s]/gi, ''))
      }}
      getEmployeeDetails()

    });
app.get("/getAll",function(req,res) {
    const getallemployees = async () => {
        const response = await axios.get('http://myapp:8888/Emp/getAll');
        var data=response.data

        var data1="<h1>All Employee Details</h1>"
            for (var i = 0; i < data.length; i++) {
                data1=data1+JSON.stringify({"Employee Id ":data[i].empid})+"<br>"+
                JSON.stringify({"Employee Name ":data[i].empName})+"<br>"+
                JSON.stringify({"Employee Mail ":data[i].empMail})+"<br>"+
                JSON.stringify({"Employee Role ":data[i].empRole})+"<br>"+
                JSON.stringify({"Employee Contact ":data[i].empContact})+"<br><br>"
            }
            data1=data1.replace(/[^\w<>/:@.\s]/gi, '')
         res.send(data1);
      }
      getallemployees()

    });
    app.get("/update", function(req, res){
        res.render("updateemp")
    });
app.post("/update",function(req,res) {
    const updateEmployee = {"empid": req.body.empid,
    "empName": req.body.empName,
    "empRole": req.body.empRole,
    "empMail": req.body.empMail,
    "empContact": req.body.empContact
    }
    const updateemployee = async () => {
        const response = await axios.post('http://myapp:8888/Emp/update/'+updateEmployee.empid,updateEmployee);
        res.send(response.data);
    }
    updateemployee()

        });

app.get("/delete", function(req, res){
    res.render("deleteemp")
});

app.post("/delete",function(req,res) {
    const EmployeeId = req.body.id;
        const deleteemployee = async () => {
            const response = await axios.delete('http://myapp:8888/Emp/delete/'+EmployeeId);
            var data=response.data;
            res.send(response.data);
    }
    deleteemployee()

        });



app.listen(3000);

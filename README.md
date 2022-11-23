## Full Stack Automation Final Project

[Short Video - Demonstration](C:/Users/sbenhamou/Documents/Wondershare Filmora 9/Recorded/10076985/VID_20221123_172708.zip)

This project was created to finalize the knowledge and skills acquired at the end of my Full Stack automation course at Atid College.

---

### _**About**_

The project demonstates a smart automation infrastructure. It is built in hierarchy order of modules. The modules contain number of classes with methods. There are main/common/helpers/actions/page_object modules. In this way, the tests can be created in very simple way with a minimum lines of code. Also the infrastructure allows to work with differend kinds of applications. Big advantage of the infrastructure is that it can be easy maintained!

### **_Project Overview_**

The project is an example of infrastructure for automation testing of different kinds of applications:

<details>

<summary>Details of kinds of applications</summary>

- Web based application
- Mobile application
- Web API
- Electron application
- Desktop application

</details>

### **_Infrastructure project includes using of:_**

<details>

<summary>Details of infrastructure</summary>

- Page Object Design Pattern
- Project Layers (Extensions/Work Flows/Test Cases...)
- Support of Different Clients/Browsers
- Failure Mechanism
- Common Functionality
- External Files Support
- Reporting System (including screenshots)
- Visual Testing
- DB support
- CI support

</details>

---

### **_List of applications were used in this project:_**

<details>

<summary>Details of applications used</summary>

- Web Application : Atidstore
- Mobile application : ExperiBank
- Web API : API exercise see [specifications](https://github.com/sbenhamou/FinalProjectShoshanaBenhamou/tree/master/APIDocumentation)
- Electron application : ToDoList
- Desktop application : Windows calculator

</details>

### **_Tools & Frameworks used in the project:_**

<details>

<summary>Details of tools and Frameworks used</summary>

- Apache Maven -  open-source build automation tool
- TestNG - Testing Framework
- Listeners - interface used to generate logs and customize the TestNG reports
- Remotemysql - interface used to create DataBase
- [Jenkins](https://www.jenkins.io/)- for tests execution
- REST Assured - for API testing
- [Allure](http://allure.qatools.ru/) Reports - as the main reporting system

</details>

### **_Tests Execution:_**

> Each application contains a limited number of tests for example. The objective being to show the construction of an infrastructure project. [[Sanity Tests]](https://github.com/sbenhamou/FinalProjectShoshanaBenhamou/tree/master/src/test/java/sanity)

### **_Known Issues:_**

Unable to run both mobile app tests and desktop app tests, due to driver conflict.
Therefore, the project is for demonstration purposes only. In production, it should be divided into several projects and will be executed separately.

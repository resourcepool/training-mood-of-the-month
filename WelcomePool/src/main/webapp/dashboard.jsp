<%@ page import="io.takima.ProjectMOTM.MOTM" %>
<%@ page import="io.takima.ProjectMOTM.MOTM_Answer" %>
<%@ page import="io.takima.ProjectMOTM.Employee" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="io.takima.controller.GradeStats" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Mood of the month</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />

    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />

    <!-- Custom Fonts -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%  ArrayList<GradeStats> gradeStats = (ArrayList<GradeStats>)request.getAttribute("GradeStats");
                            double avg = 0;
                            for (GradeStats stats : gradeStats) {
                                avg += stats.grade.getValue() * stats.percent;
                            }
                            avg = Math.round(avg * 100.0) / 100.0;
                        %>

<div class="container-fluid" id="dashboard">

    <div class="half">
        <div class="month">
            <p class="title"><%=((MOTM)request.getAttribute("LastMotm")).getTitle()%></p>
            <p class="subtitle">MOOD OF THE MONTH</p>
        </div>

        <div class="details">
                                    <% for (GradeStats stats : gradeStats) {
                                        double showPercent = Math.round(stats.percent * 10000) / 100;
                                        int gradeValue = (int)stats.grade.getValue();
                                    %>
                                    <div class="mood">
                                        <div class="img-container">
                                            <img src="img/<%=gradeValue%>.png" alt="super"/>
                                        </div>
                                        <div class="progress-bar-container">
                                            <span class="desc">Vote count: <%=stats.nb%></span>
                                            <div class="progress">
                                                <div class="progress-bar progress-bar-<%=gradeValue%>" role="progressbar" aria-valuenow="<%=stats.nb%>"
                                                     aria-valuemin="0" aria-valuemax="100" style="width:<%=showPercent%>%">
                                                    <span class=""><%=showPercent%>%</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <%}%>
                                </div>
    </div>


    <div class="half-2">

        <div class="global">
            <div class="global-mood">
              <div class="img-container">
                <img class="mood" src="${pageContext.request.contextPath}/img/<%=Math.round(avg)  %>.png" alt=""/>
              </div>
              <div class="notation">
                  <p class="title">GLOBAL MOOD</p>
                  <span class="note"><%=avg%></span>
                  <span class="note-on">/5</span>
              </div>
            </div>
        </div>

        <div class="comments">
            <h2 class="title">Comments</h2>
            <div style="max-height:515px;overflow-y:scroll;">
            <% ArrayList<MOTM_Answer> motmAnswers = (ArrayList<MOTM_Answer>)request.getAttribute("MotmAnswers");%>
            <% for (MOTM_Answer motmAnswer : motmAnswers) {%>
            <div class="comment-container">
                <div class="note">
                    <img class="mood" src="${pageContext.request.contextPath}/img/<%= (int)motmAnswer.getGrade().getValue()%>.png" alt=""/>
                </div>
                <div class="comment">
                    <%= motmAnswer.getMessage()%>
                </div>
            </div>
            <%}%>
            </div>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="../js/jquery-3.1.1.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../js/bootstrap.min.js"></script>

</body>

</html>

# Scala-Rest

1-->  git clone https://github.com/ahmetsalavran/Scala-Rest.git

2--> cd Scala-Rest

3--> sbt run


*******CURL***********

GET  /healthcheck

curl --location --request GET "http://localhost:9000/healthcheck"

GET /messages/:id

curl --location --request GET "http://localhost:9000/messages/616c30c2b161b15f6ae4a216"

POST /messages

curl --location --request POST 'http://localhost:9000/messages' \
--header 'User-Agent: emilie' \
--header 'Content-Type: application/json' \
--data-raw '{"message":"Oh my gosh! It’s racism #FuckThePolice #BlackLivesMatters"}'

DELETE /messages/:id

curl --location --request DELETE 'http://localhost:9000/messages/616c30c2b161b15f6ae4a216'

GET /messages

curl --location --request GET 'http://localhost:9000/messages?tag=FuckThePolice,BlackLivesMatters&page=1&count=2' \
--header 'User-Agent: emilie' \
--header 'Content-Type: application/json' \
--data-raw '{"message":"Oh my gosh! It’s racism #FuckThePolice #BlackLivesMatters"}'
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Apache JMeter Dashboard</title>

     <!-- Bootstrap Core CSS -->
    <link href="sbadmin2-1.0.7/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="sbadmin2-1.0.7/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="sbadmin2-1.0.7/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Dashboard css -->
    <link href="content/css/dashboard.css" rel="stylesheet">

    <!-- Table sorter -->
    <link href="content/css/theme.blue.css" rel="stylesheet">

    <!-- icon -->
    <link rel="icon" type="image/png" href="content/pages/icon-apache.png" />

    <!-- Custom Fonts -->
    <link href="sbadmin2-1.0.7/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

<body>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Apache JMeter Dashboard</a>
            </div>
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="content/pages/OverTime.html">Over Time</a>
                                </li>
                                <li>
                                    <a href="content/pages/Throughput.html">Throughput</a>
                                </li>
                                <li>
                                    <a href="content/pages/ResponseTimes.html">Response Times</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Customs Graphs<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="content/pages/CustomsGraphs.html">Over Time</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                     <div class="panel panel-default" >
                        <div class="panel-heading" style="text-align:center;">
                           <p class="dashboard-title">Test and Report information</p>
                        </div>
                        <div class="panel-body">
                        <table id="generalInfos" class="table table-bordered table-condensed " >
                            <tr>
                                <td>Source file</td>
                                <td>"Results.csv"</td>
                            </tr>
                            <tr>
                                <td>Start Time</td>
                                <td>"27.10.2021 14:28"</td>
                            </tr>
                            <tr>
                                <td>End Time</td>
                                <td>"27.10.2021 14:29"</td>
                            </tr>
                                <tr>
                                    <td>Filter for display</td>
                                    <td>""</td>
                                </tr>
                        </table>
                     </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="panel panel-default" style="text-align:center;">
                        <div class="panel-heading">
                           <p class="dashboard-title"><a href="https://en.wikipedia.org/wiki/Apdex" target="_blank">APDEX (Application Performance Index)</a></p>
                        </div>
                        <div class="panel-body">
                            <section id="apdex" class="col-md-12 table-responsive">
                                <table id="apdexTable" class="table table-bordered table-condensed tablesorter ">
                                </table>
                            </section>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6" >
                    <div class="panel panel-default" style="text-align:center;">
                        <div class="panel-heading">
                           <p class="dashboard-title">Requests Summary</p>
                        </div>
                           <div class="panel-body">
                            <div class="flot-chart" style="height:200px;">
                                <div class="flot-chart-content" id="flot-requests-summary" style="height:200px;"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="panel panel-default" style="text-align:center;">
                       <div class="panel-heading" >
                           <p class="dashboard-title">Statistics</p>
                       </div>
                <div class="panel-body ">
                    <section class="col-md-12 table-responsive">
                        <table id="statisticsTable" class="table table-bordered table-condensed tablesorter " >
                        </table>
                    </section>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="panel panel-default" style="text-align:center;">
                    <div class="panel-heading">
                        <p class="dashboard-title">Errors</p>
                    </div>
                    <div class="panel-body">
                        <section class="col-md-12 table-responsive">
                            <table id="errorsTable" class="table table-bordered table-condensed tablesorter ">
                            </table>
                        </section>
                    </div>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="panel panel-default" style="text-align:center;">
                    <div class="panel-heading">
                        <p class="dashboard-title">Top 5 Errors by sampler</p>
                    </div>
                    <div class="panel-body">
                        <section class="col-md-12 table-responsive">
                            <table id="top5ErrorsBySamplerTable" class="table table-bordered table-condensed tablesorter ">
                            </table>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="sbadmin2-1.0.7/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="sbadmin2-1.0.7/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="sbadmin2-1.0.7/bower_components/flot/excanvas.min.js"></script>
    <script src="sbadmin2-1.0.7/bower_components/flot/jquery.flot.js"></script>
    <script src="sbadmin2-1.0.7/bower_components/flot/jquery.flot.pie.js"></script>
    <script src="sbadmin2-1.0.7/bower_components/flot/jquery.flot.resize.js"></script>
    <script src="sbadmin2-1.0.7/bower_components/flot/jquery.flot.time.js"></script>
    <script src="sbadmin2-1.0.7/bower_components/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
    <script src="sbadmin2-1.0.7/bower_components/flot-axislabels/jquery.flot.axislabels.js"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="sbadmin2-1.0.7/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <script src="content/js/dashboard-commons.js"></script>
    <script src="content/js/dashboard.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="sbadmin2-1.0.7/dist/js/sb-admin-2.js"></script>
    <script type="text/javascript" src="content/js/jquery.tablesorter.min.js"></script>

</body>

</html>

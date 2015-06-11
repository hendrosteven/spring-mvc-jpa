<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="assets/css/foundation.css" />
        <script src="assets/js/vendor/modernizr.js"></script>
        <title>Departemen</title>
    </head>
    <body>
        <div class="contain-to-grid sticky">
            <nav class="top-bar" data-topbar role="navigation">
                <ul class="title-area">
                    <li class="name"><h1>
                            <a href="#"><img src="assets/img/icon.png"/>&nbsp;Data Karyawan</a>
                        </h1></li>
                    <li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
                </ul>
                <section class="top-bar-section">
                    <ul class="right">
                        <li><a href="/web03">Depan</a></li>
                        <li class="active"><a href="viewdepartemen">Departemen</a></li>
                        <li><a href="#">Karyawan</a></li>
                    </ul>
                </section>
            </nav>
        </div>
        <div class="row">          
            <div class="large-12 columns">
                <h4>Daftar Departemen</h4>   
                <ul class="tabs" data-tab>
                    <li class="tab-title active"><a href="#panel1">Data</a></li>
                    <li class="tab-title"><a href="#panel2">Input</a></li>                    
                </ul>
                <div class="tabs-content">
                    <div class="content active" id="panel1">
                        <table class="table table-bordered" style="width: 100%">
                            <thead>
                                <tr>
                                    <th>No</th>
                                    <th>Kode</th>
                                    <th>Nama</th>
                                    <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="no" value="1"/>
                                <c:forEach items="${departemen}" var="dep">
                                    <tr>
                                        <td style="width: 5%">${no}.</td>
                                        <td>${dep.kode}</td>
                                        <td>${dep.nama}</td>
                                        <td style="width: 15%">
                                            <a href="deletedepartemen?id=${dep.id}" class="label alert">Del</a>
                                            <a href="" class="label success">Edit</a>
                                            <a href="" class="label">View</a>
                                        </td>
                                    </tr>
                                    <c:set var="no" value="${no+1}"/>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="content" id="panel2">
                        <h5>Input New Departemen</h5>
                        <form action="insertdepartemen" method="post">
                            <div class="row">
                                <div class="large-6 columns">
                                    <label>Kode Departemen
                                        <input type="text" placeholder="Kode Departemen" name="txtKode" />
                                    </label>
                                </div>                                    
                            </div>
                            <div class="row">
                                <div class="large-6 columns">
                                    <label>Nama Departemen
                                        <input type="text" placeholder="Nama Departemen" name="txtNama" />
                                    </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="large-6 columns">
                                    <input type="submit" value="Save" class="button small"/>
                                </div>
                            </div>
                        </form>
                    </div>                    
                </div>
            </div>
        </div>

        <script src="assets/js/vendor/jquery.js"></script>
        <script src="assets/js/foundation.min.js"></script>
        <script>
            $(document).foundation();
        </script>
    </body>
</html>
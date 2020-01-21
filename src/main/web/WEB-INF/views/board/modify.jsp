<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../includes/header.jsp"%>

             <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            DataTables Advanced Tables
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <form action="/board/modify" method="post">
                            <div class="form-group">

                            <label>글번호</label> <input class="form-control" name="bno" value="<c:out value="${board.bno}"/>">
                            </div>

                            <div class="form-group">
                            <label>제목</label> <input class="form-control" name="title" value="<c:out value="${board.title}"/>" >
                            </div>

                            <div class="form-group">
                            <label>내용</label>
                                <textarea class="form-control" name="content">
                                <c:out value="${board.content}"/>
                               </textarea>
                            </div>

                            <div class="form-group">
                            <label>작성자</label> <input class="form-control" name="writer" value="<c:out value="${board.writer}"/>">
                            </div>
                            <input type="submit" value="저장" class="btn btn-default">
                            <a href="/board/list"><button data-oper="list" class="btn btn-info">목록</button></a>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        <!-- /#page-wrapper -->

    </div>
<%@include file="../includes/footer.jsp"%>

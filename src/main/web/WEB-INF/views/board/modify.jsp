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
                                <button data-oper="modify" type="submit" class="btn btn-danger">저장</button>
                                <button data-oper="remove" type="submit" class="btn btn-danger">삭제</button>
                                <button data-oper="list" type="submit" class="btn btn-danger">목록</button>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        <!-- /#page-wrapper -->
    </div>
    <script>
        $(document).ready(function () {
            var formObj = $("form");
            
            $('button').on("click",function (e) {

                e.preventDefault();

                var operation = $(this).data("oper");

                console.log(operation);
                if(operation === 'modify'){
                    // e.preventDefault();
                    formObj.append("<input type='hidden' name='pageNum' value='${cri.pageNum}'>");
                    formObj.append("<input type='hidden' name='amount' value='${cri.amount}'>");
                    formObj.append("<input type='hidden' name='type' value='${cri.type}'>");
                    formObj.append("<input type='hidden' name='keyword' value='${cri.keyword}'>");
                }else if(operation === 'remove'){
                    formObj.attr("action", "/board/remove");
                    formObj.append("<input type='hidden' name='pageNum' value='${cri.pageNum}'>");
                    formObj.append("<input type='hidden' name='amount' value='${cri.amount}'>");
                    formObj.append("<input type='hidden' name='type' value='${cri.type}'>");
                    formObj.append("<input type='hidden' name='keyword' value='${cri.keyword}'>");
                }else if (operation === 'list'){
                    // self.location = "/board/list";
                    formObj.attr("action","/board/list").attr("method","get");
                    formObj.empty();
                    formObj.append("<input type='hidden' name='pageNum' value='${cri.pageNum}'>");
                    formObj.append("<input type='hidden' name='amount' value='${cri.amount}'>");
                    formObj.append("<input type='hidden' name='type' value='${cri.type}'>");
                    formObj.append("<input type='hidden' name='keyword' value='${cri.keyword}'>");

                }
                formObj.submit();
            });
            
        });
    </script>
<%@include file="../includes/footer.jsp"%>

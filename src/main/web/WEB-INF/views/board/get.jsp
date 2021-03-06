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
                            <div class="form-group">
                            <label>글번호</label> <input class="form-control" name="bno" value="<c:out value="${board.bno}"/>" readonly="readonly">
                            </div>

                            <div class="form-group">
                            <label>제목</label> <input class="form-control" name="title" value="<c:out value="${board.title}"/>" readonly="readonly">
                            </div>

                            <div class="form-group">
                            <label>내용</label>
                            <textarea class="form-control" name="content" readonly="readonly">
                            <c:out value="${board.content}" />
                                </textarea>
                            </div>

                            <div class="form-group">
                            <label>작성자</label> <input class="form-control" name="writer" value="<c:out value="${board.writer}"/>" readonly="readonly">
                            </div>

                           <button data-oper="modify" class="btn btn-default">수정</button>
                           <button data-oper="list" class="btn btn-info">목록</button>

                            <form id="operForm" action="board/modify" method="get">
                                <input type="hidden" name="bno" value="${board.bno}">
                                <input type="hidden" name="pageNum" value="${cri.pageNum}">
                                <input type="hidden" name="type" value="${cri.type}">
                                <input type="hidden" name="keyword" value="${cri.keyword}">

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        <!-- /#page-wrapper -->

    </div>
<script>
    $(document).ready(function () {
        var operForm = $("#operForm");
        ($("button[data-oper='modify']")).on("click",function (e) {
            <%--operForm.append("<input type='hidden' name='bno' value="+${board.bno} +">");--%>
            <%--operForm.append("<input type='hidden' name='pageNum' value='"+${cri.pageNum} +"'>");--%>
            <%--operForm.append("<input type='hidden' name=amount value='"+${cri.amount} +"'>");--%>
            operForm.attr("action","/board/modify").submit();
        });

        $("button[data-oper='list']").on("click",function(e) {
            // operForm.find("#bno").remove();
            operForm.attr("action","/board/list");
            <%--operForm.append("<input type='hidden' name='pageNum' value='"+${cri.pageNum} +"'>");--%>
            <%--operForm.append("<input type='hidden' name='amount' value='"+${cri.amount} +"'>");--%>
            <%--operForm.append("<input type='hidden' name='type' value='"+${cri.type} +"'>");--%>
            <%--operForm.append("<input type='hidden' name='keyword' value='"+${cri.keyword} +"'>");--%>
            operForm.submit();
    })
        
    })
</script>
<%@include file="../includes/footer.jsp"%>

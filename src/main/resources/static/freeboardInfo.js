  $(function() {
        function getList() {
            $.ajax({
                url : "/freeboardCommentList",
                type : "get",
                dataType : "json",
                success : function(data) {
                    var table = "" ;
                    $(data).find("member").each(function() {
                        table +="<tr>";
                        table +="<td>"+$(this).find("id").text()+"</td>";
                        table +="<td>"+$(this).find("password").text()+"</td>";
                        table +="<td>"+$(this).find("name").text()+"</td>";
                        table +="<td>"+$(this).find("email").text()+"</td>";
                        table +="<td>" ;
                        table += "<input type='button' value='삭제' id='del' name='"+$(this).find("id").text()+"' />";
                        table +="</tr>";
                    });
                    $("#tbody").append(table);    
                },
                error : function name() {
                    alert("실패")
                }
            });
        }// getList()끝
        
        // 중복확인
        $("#id").keyup(function() {
            $.ajax({
                url : "${pageContext.request.contextPath}/memberIdChk",
                type : "get",
                dataType : "text",
                data : "id="+$("#id").val(), // 서블릿으로 넘어가는 파라미터값
                success : function(data) {
                    $("span").html(data);
                },
                error : function name() {
                    alert("실패");
                }
            });
        });



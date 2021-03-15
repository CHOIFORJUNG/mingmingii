function getboardNo (boardVO){

    console.log(boardVO);

    var boardNo = [[${boardVO.boardNo}]];

    console.log(boardNo);

    var test = document.getElementById('test');
    test.addEventListener('click', function () {
        alert('Hello world');
    })

    $(document).ready(function () {
        $.getJSON("/replies/all/" + boardNo, function (data) {
            console.log("결과는 =" + JSON.stringify(data));
            console.log((data.replyList.length));
            var str = "";

            $(data.replyList).each(function () {
                var replyWriter = "'" + this.replyWriter + "'";
                console.log("replyWriter!!" + replyWriter);

                str += "<li data-replyNo='" + this.replyNo + "' class='replyList' style='text-align:left;'>"
                    + "<h4>" + this.replyNo + "</h4>"
                    + "<h4>" + this.replyWriter + "</h4>"
                    + "<blockquote>" + this.replyContents + "</blockquote>"
                    + "<button type='button' class='btn btn-primary' data-toggle='modal' data-target='#modifyDiv'>수정</button>"
                    + "</li>"
                    + "<hr/>";

                $("#reply").html(str);
            })
        })


        $("#reply").on("click", ".replyList button", function () {  // 댓글 옆에 수정버튼 클릭 시 모달 창
            var li = $(this).parent(); /* li 선택 */
            var replyNo = li.attr("data-replyNo"); /*data-rebno값 얻어오기*/
            //	var reContent = li.text();

            //alert("댓글번호 : "+rebno+"  수정할 내용 : "+reContent);
            $(".title-dialog").html(replyNo);
            //	$("#reContent").val(reContent);
            //	$("#modifyDiv").show("slow");

            /*지원추가*/
            var replyWriter = $(this).parent().find('h4').text();
            var replyContents = $(this).prev().text();

            console.log("내용");
            console.log(replyWriter);
            console.log(replyContents);

            $('#replyWriter').val(replyWriter);
            $('#replyContents').val(replyContents);

        });

        //삭제처리
        $("#reDelBtn").on("click", function () {
            var replyNo = $(".title-dialog").html();

            $.ajax({
                type: 'delete',
                url: '/replies/delete/' + replyNo,
                headers: {
                    "Content-Type": "application/json",
                    "X-HTTP-Method-Override": "DELETE"
                },
                dataType: 'text',
                data: JSON.stringify({
                    replyNo: replyNo
                }),
                success: function (result) {
                    console.log("result:" + result);
                    if (result == 'Success') {
                        alert("삭제 성공!!!");
                        //$("#modifyDiv").hide("slow");  // Modal 닫기
                        //  $("#modifyDiv").modal('hide');  // Modal 닫기 (지원)
                        location.reload();
                    }
                }

            })// ajax
        })

        // 수정 처리
        $("#reModifyBtn").on("click", function () {

            var replyNo = $(".title-dialog").html();
            var replyContents = $(this).parents().find('#replyContents').val();  // 댓글의 내용 가져오기

            console.log("수정할 내용====");
            console.log(replyNo);
            console.log(replyContents);

            $.ajax({
                type: 'put',
                url: 'replies/update/' + replyNo,
                headers: {
                    "Content-Type": "application/json",
                    "X-HTTP-Method-Override": "PUT"
                },
                data: JSON.stringify({replyContents: replyContents}),
                dataType: 'text',
                success: function (result) {
                    console.log("result:" + result);
                    if (result == 'Success') {
                        alert("수정 성공!!!");
                        //$("#modifyDiv").hide("slow");
                        //$("#modifyDiv").modal('hide');  // Modal 닫기

                        location.reload();		//reload!! 이런식으로 닫히고 새로고침 하게 정지원씨가 해주었음!!ㅋㅋㅋㅋㅋ
                        $(".modal-dialog").modal('hide');
                        //reListAll();  // 댓글 목록 갱신
                    }
                }

            });// ajax
        }); // #reModifyBtn
    })
    // $("#deleteDiv").on("click", function(){
    //
    //     var replyNo = this.replyNo;
    //
    //     $.ajax({
    //         type:'delete',
    //         url:'/replies/'+replyNo,
    //         headers :{
    //             "Content-Type" : "application/json",
    //             "X-HTTP-Method-Override" : "DELETE"
    //         },
    //         dataType: 'text',
    //         success: function(result){
    //             console.log("result:" + result);
    //             if(result == 'Success'){
    //                 alert("삭제 성공!!!");
    //                 //$("#modifyDiv").hide("slow");  // Modal 닫기
    //                 $("#modifyDiv").modal('hide');  // Modal 닫기 (지원)
    //                 //reListAll(); // 댓글 목록 갱신
    //             }
    //         }
    //
    //     });// ajax
    // }); // #reDelBtn

    //댓글 입력

    $("#submitBtn").on("click", function () {
        var reWriter = $("#writer").val();
        var reContents = $("#content").val();
        var boardNo = '${BoardVO.boardNo}'; //타임리프형식으로 써줘야한다.
        $.ajax({
            type: 'post',
            url: '/replies',
            headers: {
                "Content-Type": "application/json",
                "X-HTTP-Method-Override": "POST"
            },
            dataType: 'text', //받는부분
            data: JSON.stringify({ //보내는부분
                boardNo: boardNo,
                replyWriter: reWriter,
                replyContents: reContents
            }),
            success: function (result) {
                if (result == 'Success') {
                    $("#writer").val("");
                    $("#content").val("");
                }
            }
        })
    })


    function deleteBoard(boardNo) {
        if (boardNo != null) {
            $(location).attr('href', '/delete?boardNo=' + boardNo);
        }
    }

    function modifyBoard(boardNo) {
        if (boardNo != null) {
            $(location).attr('href', '/update?boardNo=' + boardNo)
        }
    }
}
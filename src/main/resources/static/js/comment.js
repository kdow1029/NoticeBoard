let comment = {
    init: function () {
        let _this = this;
        $('#btn-comment-save').on('click', function () {
            _this.commentSave();
        });

    },
    commentSave: function () {
        let data = {
            comment: $('#comment').val(),
            // writer: $('#writer').val(),
            board: {
                nno: $('#nno').val()
            }
        };

        let nno = $('#nno').val();

        $.ajax({
            type: 'POST',
            url: '/api/post/' + nno + '/comment' ,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8,',
            data: JSON.stringify(data),
        }).done(function () {
            alert("등록");
            window.location.href = "/board";
        }).fail(function () {
            alert("실패");
            console.log(data)
        })
    }
};
comment.init();
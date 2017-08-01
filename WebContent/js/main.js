$(document).ready(function() {

	// 検索ボタンクリック時
	$("#search").click(function(){

      // 検索ボックスのメールアドレス取得
      var mail = $.trim($("#login-email").val());

	  // JSONファイルの読み込み
	  $.getJSON("json/data.json", function(data){

	    // 検索ボタンを押した場合は、検索ボックスの入力有無に関わらず、すべてのデータを表示

        // 要素削除
        $("#tb-meisai td").remove();

        for(var i in data){
    	    var num = parseInt(i, 10) +1;
    	    // 画面表示
    	  $("#tb-meisai").append(
    	   	$("<tr>")
    	    .append($("<td><input type=\"checkbox\"></td>"))
    	    .append($("<td>" + num + "</td>"))
    	    .append($("<td>" + data[i].email + "</td>"))
    	    .append($("<td>" + data[i].passwd + "</td>"))
    	    .append($("<td>" + data[i].insdate + "</td>"))
    	    .append($("<td>" + data[i].upddate + "</td></tr>\n"))

    	  );
	    }
        if (mail != "") { // メールアドレスの入力がある場合、
		    // 正規表現使用
		    var regExp = new RegExp(mail);

		    // 検索文字列と一致するメールアドレスが存在する行を表示する
		    $('#tb-meisai').find('tr').hide().each(function(){
		        var tr = $(this);
		        $(this).find('td').eq(2).each(function(){
		            if ($(this).text().match(regExp)) {
		                tr.show();
		            }
		        })
		    });
		}

	  });

	});



});
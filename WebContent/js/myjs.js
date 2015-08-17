/**
 * Created by Leo on 2015/1/4.
 */
$(function() {
    var sWidth = $("#focus").width(); //鑾峰彇鐒︾偣鍥剧殑瀹藉害锛堟樉绀洪潰绉級
    var len = $("#focus ul li").length; //鑾峰彇鐒︾偣鍥句釜鏁�
    var index = 0;
    var picTimer;

    
    //浠ヤ笅浠ｇ爜娣诲姞鏁板瓧鎸夐挳鍜屾寜閽悗鐨勫崐閫忔槑鏉★紝杩樻湁涓婁竴椤点�涓嬩竴椤典袱涓寜閽�
    var btn = "<div class='btnBg'></div><div class='btn'>";
    for(var i=0; i < len; i++) {
        btn += "<span></span>";
    }
    btn += "</div><div class='preNext pre'></div><div class='preNext next'></div>";
    $("#focus").append(btn);
    $("#focus .btnBg").css("opacity",0.5);

    //涓哄皬鎸夐挳娣诲姞榧犳爣婊戝叆浜嬩欢锛屼互鏄剧ず鐩稿簲鐨勫唴瀹�
    $("#focus .btn span").css("opacity",0.4).mouseover(function() {
        index = $("#focus .btn span").index(this);
        showPics(index);
    }).eq(0).trigger("mouseover");

    //涓婁竴椤点�涓嬩竴椤垫寜閽�鏄庡害澶勭悊
    $("#focus .preNext").css("opacity",0.2).hover(function() {
        $(this).stop(true,false).animate({"opacity":"0.5"},300);
    },function() {
        $(this).stop(true,false).animate({"opacity":"0.2"},300);
    });

    //涓婁竴椤垫寜閽�
    $("#focus .pre").click(function() {
        index -= 1;
        if(index == -1) {index = len - 1;}
        showPics(index);
    });

    //涓嬩竴椤垫寜閽�
    $("#focus .next").click(function() {
        index += 1;
        if(index == len) {index = 0;}
        showPics(index);
    });

    //鏈緥涓哄乏鍙虫粴鍔紝鍗虫墍鏈塴i鍏冪礌閮芥槸鍦ㄥ悓涓�帓鍚戝乏娴姩锛屾墍浠ヨ繖閲岄渶瑕佽绠楀嚭澶栧洿ul鍏冪礌鐨勫搴�
    $("#focus ul").css("width",sWidth * (len));

    //榧犳爣婊戜笂鐒︾偣鍥炬椂鍋滄鑷姩鎾斁锛屾粦鍑烘椂寮�鑷姩鎾斁
    $("#focus").hover(function() {
        clearInterval(picTimer);
    },function() {
        picTimer = setInterval(function() {
            showPics(index);
            index++;
            if(index == len) {index = 0;}
        },4000); //姝�000浠ｈ〃鑷姩鎾斁鐨勯棿闅旓紝鍗曚綅锛氭绉�
    }).trigger("mouseleave");

    //鏄剧ず鍥剧墖鍑芥暟锛屾牴鎹帴鏀剁殑index鍊兼樉绀虹浉搴旂殑鍐呭
    function showPics(index) { //鏅�鍒囨崲
        var nowLeft = -index*sWidth; //鏍规嵁index鍊艰绠梪l鍏冪礌鐨刲eft鍊�
        $("#focus ul").stop(true,false).animate({"left":nowLeft},300); //閫氳繃animate()璋冩暣ul鍏冪礌婊氬姩鍒拌绠楀嚭鐨刾osition
        //$("#focus .btn span").removeClass("on").eq(index).addClass("on"); //涓哄綋鍓嶇殑鎸夐挳鍒囨崲鍒伴�涓殑鏁堟灉
        $("#focus .btn span").stop(true,false).animate({"opacity":"0.4"},300).eq(index).stop(true,false).animate({"opacity":"1"},300); //涓哄綋鍓嶇殑鎸夐挳鍒囨崲鍒伴�涓殑鏁堟灉
    }
});
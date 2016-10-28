<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>管理菜单</title>
        <meta name="Author" content="IBM Team" />
        <meta name="Copyright" content="IBM" />
        <link href="/oss-admin/webstatic/css/menuTree.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="/oss-admin/webstatic/js/json2.js"></script>
<style>
  article, aside, figure, footer, header, hgroup, 
  menu, nav, section { display: block; }
  .west{
    width:200px;
    padding:10px;
  }
  .north{
    height:100px;
  }
</style>
<script type="text/javascript">
$(function() {
	tabClose();
	tabCloseEven();

	// 导航菜单绑定的初始化
	$("#wnav").accordion( {
		animate : false
	});
	$.ajax({
	            type : "POST",
	            dataType : "json",
	            url : 'findAllJsonMenu.htm',
	            success : function(data) {
	            	if (data.d){
		            	addNav(data.d);
			        } else {
			        	addNav(data);
			        }
					InitLeftMenu();
	            },
	            error : function(err) {
	            	if(err.getResponseHeader("session-status") == 'timeout') {
				   		window.location.href='/oss-admin/timeout.htm';
				 	} else {
			       		$.messager.alert('系统提示', '获取菜单异常!', 'error');
		          	}
	                
	            }
	});
});

function Clearnav() {
	var pp = $('#wnav').accordion('panels');

	$.each(pp, function(i, n) {
		if (n) {
			var t = n.panel('options').title;
			$('#wnav').accordion('remove', t);
		}
	});

	pp = $('#wnav').accordion('getSelected');
	if (pp) {
		var title = pp.panel('options').title;
		$('#wnav').accordion('remove', title);
	}
}

function addNav(data) {

    /**
     * 判断是否有expectUri
     */
    var hasExceptUri = false;
    var tab={};
    if(!$.isEmptyObject("${expectUri}")	){
        hasExceptUri=true;
    }

    $.each(data, function(i, sm) {
        var menulist = "";
        if(sm.children) {
            menulist += '<ul>';
            $.each(sm.children, function(j, o) {
                menulist += '<li><div><a ref="' + o.id + '" href="#" rel="'
                        + o.url + '" ><span class="icon ' + o.iconCls
                        + '" >&nbsp;</span><span class="nav">' + o.name
                        + '</span></a></div></li> ';
                if(hasExceptUri&&o.url==("${expectUri}"+".htm")){
                    tab.url =o.url+"${queryString}";
                    tab.title = o.name;
                    tab.fathername = sm.name;
                }
            });
            menulist += '</ul>';
        }

        $('#wnav').accordion('add', {
            title : sm.name,
            content : menulist,
            iconCls : 'icon ' + sm.iconCls
        });

    });

    var pp = $('#wnav').accordion('panels');
    var t = pp[0].panel('options').title;
    if(hasExceptUri){
        t = tab.fathername
		if(!$.isEmptyObject("${expectUri}")&&(tab.url==undefined||tab.url=="")){
            tab.title="临时";
            tab.url="${expectUri}"+".htm"+"${queryString}";
		}
        addTab(tab.title, tab.url, 'icon icon-nav');
    }
    $('#wnav').accordion('select', t);

}

// 初始化的左侧
function InitLeftMenu() {
	
	hoverMenuItem();

	$('#wnav li a').live('click', function() {
		var tabTitle = $(this).children('.nav').text();

		var url = $(this).attr("rel");
		var menuid = $(this).attr("ref");

		addTab(tabTitle, url, 'icon icon-nav');
		$('#wnav li div').removeClass("selected");
		$(this).parent().addClass("selected");
	});

}

/**
 * 菜单项的鼠标Hover
 */
function hoverMenuItem() {
	$(".easyui-accordion").find('a').hover(function() {
		$(this).parent().addClass("hover");
	}, function() {
		$(this).parent().removeClass("hover");
	});
}

function addTab(subtitle, url, icon) {
	if (!$('#tabs').tabs('exists', subtitle)) {
		$('#tabs').tabs('add', {
			title : subtitle,
			content : createFrame(url),
			closable : true,
			icon : icon
		});
	} else {
		$('#tabs').tabs('select', subtitle);
		var currTab = $('#tabs').tabs('getSelected');
		var oldUrl = $(currTab.panel('options').content).attr('src');
		if(url != oldUrl){
			//地址改变再更新add by hepeng 2015/10/15
			$('#tabs').tabs('update', {
				tab : currTab,
				options : {
					content : createFrame(url)
				}
			});
		}else{
			$('#mm-tabupdate').click();
		}
	}
	tabClose();
}

function createFrame(url) {
	var s = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
	return s;
}

function tabClose() {
	/* 双击关闭TAB的选项卡 */
	$(".tabs-inner").dblclick(function() {
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close', subtitle);
	});
	/* 为选项卡绑定右键 */
	$(".tabs-inner").bind('contextmenu', function(e) {
		$('#mm').menu('show', {
			left : e.pageX,
			top : e.pageY
		});

		var subtitle = $(this).children(".tabs-closable").text();

		$('#mm').data("currtab", subtitle);
		$('#tabs').tabs('select', subtitle);
		return false;
	});
}

// 绑定右键菜单事件
function tabCloseEven() {
	// 刷新
	$('#mm-tabupdate').click(function() {
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		if(url != undefined) {
			$('#tabs').tabs('update', {
				tab : currTab,
				options : {
					content : createFrame(url)
				}
			});
		}
	});
	// 关闭当前
	$('#mm-tabclose').click(function() {
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close', currtab_title);
	});
	// 全部关闭
	$('#mm-tabcloseall').click(function() {
		$('.tabs-inner span').each(function(i, n) {
			if(n.innerText != '首页') {
				var t = $(n).text();
				$('#tabs').tabs('close', t);
			}
		});
	});
	// 关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function() {
		$('#mm-tabcloseright').click();
		$('#mm-tabcloseleft').click();
	});
	// 关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function() {
		var nextall = $('.tabs-selected').nextAll();
		if (nextall.length == 0) {
			return false;
		}
		nextall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#tabs').tabs('close', t);
		});
		return false;
	});
	// 关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function() {
		var prevall = $('.tabs-selected').prevAll();
		if (prevall.length == 0) {
			return false;
		}
		prevall.each(function(i, n) {
			if(n.innerText != '首页') {
				var t = $('a:eq(0) span', $(n)).text();
				$('#tabs').tabs('close', t);
			}
		});
		return false;
	});

	// 退出
	$("#mm-exit").click(function() {
		$('#mm').menu('hide');
	});
}

// 弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}


		

    </script>
    </head>
    <body class="easyui-layout">
	    <div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
		    <div id='wnav' class="easyui-accordion" fit="true" border="false">
			<!--  导航内容 -->
				
			</div>
		</div>
		<div region="center">
		    <div class="easyui-tabs" fit="true" border="false" id="tabs">
		      <div title="首页">
		      	<img src="/oss-admin/webstatic/images/background.jpg" width="100%" height="100%"></img>
		      </div>
		    </div>
  		</div>
  		<div id="mm" class="easyui-menu" style="width:150px;">
			<div id="mm-tabupdate">刷新</div>
			<div class="menu-sep"></div>
			<div id="mm-tabclose">关闭</div>
			<div id="mm-tabcloseall">全部关闭</div>
			<div id="mm-tabcloseother">除此之外全部关闭</div>
			<div class="menu-sep"></div>
			<div id="mm-tabcloseright">当前页右侧全部关闭</div>
			<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
			<div class="menu-sep"></div>
			<div id="mm-exit">退出</div>
		</div>
    </body>
</html>

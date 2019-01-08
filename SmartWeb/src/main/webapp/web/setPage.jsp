<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class = "setPage row">
	<div class="set_pageMain">
		<div class="row" style="margin: 0">
			<ul class="nav nav-tabs" id="myTab">
			  <li class="active"><a href="#cellTable">小区表设置</a></li>
			  <li><a href="#cellGroupTable">小区组设置</a></li>
			  <li><a href="#topCellValueTable">top小区临界值设置</a></li>
			   <li><a href="#updateColorTable">颜色渲染设置</a></li>
			   <!-- <li><a href="#updateNumbers">显示15分钟个数</a></li> -->
			</ul>
			<div class="tab-content">
			  <div class="tab-pane" id="cellGroupTable">
			  <!-- 小区组导入页面 -->
			  	 <div class="col-md-14 col-lg-3">
			  	 	<h4>添加小区组数据</h4>
					<a href="javascript:;" class="upload">
						点击选择excel文件
					    <input id="excel-file" class="change" type="file"
					    accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel" />
					</a>
					<input  type="text"  class="tagName" placeholder="请输入小区组名称(22个字符以内)">
					<button class="btn submit" >提交小区组数据</button>
					<div class="excelResult"></div>
					<table id="mappingTable" class="col-lg-6 table table-hover table-bordered table-striped table-condensed">
						<thead>
							<tr><td>小区组名称</td><td>删除</td><td>导出</td></tr>
						</thead>
						<tbody></tbody>
					</table>
					<h4>更新小区组数据</h4>
					<div>
					<a href="javascript:;" class="upload">
						点击选择excel文件
					    <input id="excel-file1" class="change" type="file"
					    accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel" />
					</a>
					<p class = "selectRange">
					  	<select class="form-control" id = "selectRange1">
						</select>
					</p>
					</div>
					
					<button class="btn upSubmit" >更新小区组数据</button>
					
					
				  </div>
				  <div class="col-md-12 col-lg-9">
					  <div class = "excelTableContainer">
					  	<table id="excelTable" class="col-lg-6 table table-hover table-bordered table-striped table-condensed">
							<thead></thead>
							<tbody></tbody>
						</table>
					  </div>
				  </div>
			  </div>
			  <div class="tab-pane active" id="cellTable">
			  		<!-- 小区表导入页面 -->
					<a href="javascript:;" class="upload">
						点击选择excel文件，更新小区表
					    <input id="cell_file" class="change" type="file"
					    accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel" />
					</a>
			  </div>
			  <div class="tab-pane " align="center" style="top: 10px" id="updateColorTable" >
			  		
			  			<select id="updateColor">
			                <option value="1">显示颜色</option>
			                <option value="0">隐藏颜色</option>
			             </select>
						<!-- <input id="showColor" type="radio" name="radio1" value="0">显示颜色</input>
				  		<input id="hiddenColor" type="radio" name="radio1" value="1">隐藏颜色</input> -->
					<button id="colorbtn" type="button" class=" btn btn-info">保存更改</button>
			  </div>
			  <div class="tab-pane " align="center" style="top: 10px" id="updateNumbers" >
			  		
			  			<div id="changenum">
							选择显示个数:
							<input type="text" id="numbers" >
							<input type="button" value="确认" id="numbtn">
						
						</div>
			  </div>
			  <div class = "tab-pane" id = "topCellValueTable">
			  	<h5>&nbsp;&nbsp;整体指标参数设置</h5>
			  	<div class="criticalAllNetTable clearfix">
			  		<table class="table table-hover table-bordered table-striped table-condensed">
			  			<thead>
			  				<tr>
			  					<th>属性</th>
			  					<th>临界值</th>
			  					
			  				</tr>
			  				
			  			</thead>
			  			<tbody>
			  				
			  			</tbody>
			  		</table>
			  		<button id="updateAllNetBtn" type="button" class="pull-right btn btn-info">添加或删除属性</button>
			  		<button id="allNetBtn" type="button" class="pull-right btn btn-info">保存更改</button>
			  	</div>
			  	<h5>&nbsp;&nbsp;Top小区指标参数设置</h5>
			  	<div class="criticalTopCellTable clearfix">
			  		<table class="table table-hover table-bordered table-striped table-condensed">
			  			<thead>
			  				<tr>
			  					<th>属性</th>
			  					<th>临界值</th>
			  					
			  				</tr>
			  				
			  			</thead>
			  			<tbody>
			  				
			  			</tbody>
			  		</table>
			  		<button id="updateTopCellBtn" type="button" class="pull-right btn btn-info">添加或删除属性</button>
			  		<button id="topCellBtn" type="button" class="pull-right btn btn-info">保存更改</button>
			  	</div>
			  </div>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="myModal" backdrop="false" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<!-- 禁止用户手动关闭 -->
					<button id = "modalClose" type="button" class="close" data-dismiss="modal" aria-hidden="true">×
					</button>
					<h4 class="modal-title" id="myModalLabel">
						更新小区组
					</h4>
				</div>
				<div class="modal-body clearfix" id ="modal_content">
					文件正在后台动态生成，（如果文件过大）请耐心等待……
				</div>
				<div class="modal-footer">
					<!-- <button type="button" class="btn btn-default" data-dismiss="modal">
						关闭
					</button>
					<button type="button" class="btn btn-primary">
						提交更改
					</button> -->
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div>
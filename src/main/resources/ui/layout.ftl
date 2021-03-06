<#macro layout breadcrumbs path>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title><#list breadcrumbs as crumb>${crumb}<#sep> -> </#list></title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.11/css/dataTables.bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/select/1.1.2/css/select.bootstrap.min.css">
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">

<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
	<nav class="navbar navbar-default">
	  <div class="container">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>                        
	      </button>
	      <a class="navbar-brand" href="#">Logo</a>
	    </div>
	    <div class="collapse navbar-collapse" id="myNavbar">
	      <ul class="nav navbar-nav">
	        <#list menuNodes as node>
	        	<@menuNode node '/ui' breadcrumbs />
	        </#list>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="#"><span class="fa fa-sign-in"></span> Login</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>
    <div class="container">
		<breadcrumbs params="crumbs: [<#list breadcrumbs as crumb>'${crumb}'<#sep>, </#list>]"></breadcrumbs>
		<#assign l=breadcrumbs?size />
		<h1>${breadcrumbs[l - 1]}</h1>
	    <#nested/>
    </div>
    <footer class="container text-center">
    	<p>&copy; 2017</p>
	</footer>
    <script src="/js/require.js" data-main="/js${path}/main"></script>
</body>
</html>
</#macro>
<#macro menuNode node parentPath breadcrumbs>
	<#local url=parentPath + '/' + node.name />
	<#local active=('/'+templatePath)?index_of(url) &gt; -1 />
	<#list node.nodes>
		<#if active>
		<li class="active">
		<#else>
		<li>
		</#if>
			<a href="${url}" class="dropdown-toggle" data-toggle="dropdown">${node.name?capitalize} <span class="caret"></span></a>
			<ul class="dropdown-menu">
				<#items as node>
					<@menuNode node url breadcrumbs />
				</#items>
			</ul>
		</li>
	<#else>
		<#if active>
		<li class="active">
		<#else>
		<li>
		</#if>
		<a href="${url}">${node.name?capitalize}</a></li>
	</#list>
</#macro>
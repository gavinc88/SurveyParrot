




<!DOCTYPE html>
<html class="   ">
  <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# object: http://ogp.me/ns/object# article: http://ogp.me/ns/article# profile: http://ogp.me/ns/profile#">
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    
    <title>SurveyParrot/src/com/cs160/surveyparrot/ChooseSurveyActivity.java at master · gavinc88/SurveyParrot · GitHub</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub" />
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub" />
    <link rel="apple-touch-icon" sizes="57x57" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/apple-touch-icon-144.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/apple-touch-icon-144.png" />
    <meta property="fb:app_id" content="1401488693436528"/>

      <meta content="@github" name="twitter:site" /><meta content="summary" name="twitter:card" /><meta content="gavinc88/SurveyParrot" name="twitter:title" /><meta content="SurveyParrot Android Application for CS 160" name="twitter:description" /><meta content="https://avatars1.githubusercontent.com/u/3280624?s=400" name="twitter:image:src" />
<meta content="GitHub" property="og:site_name" /><meta content="object" property="og:type" /><meta content="https://avatars1.githubusercontent.com/u/3280624?s=400" property="og:image" /><meta content="gavinc88/SurveyParrot" property="og:title" /><meta content="https://github.com/gavinc88/SurveyParrot" property="og:url" /><meta content="SurveyParrot Android Application for CS 160" property="og:description" />

    <link rel="assets" href="https://github.global.ssl.fastly.net/">
    <link rel="conduit-xhr" href="https://ghconduit.com:25035/">
    <link rel="xhr-socket" href="/_sockets" />

    <meta name="msapplication-TileImage" content="/windows-tile.png" />
    <meta name="msapplication-TileColor" content="#ffffff" />
    <meta name="selected-link" value="repo_source" data-pjax-transient />
    <meta content="collector.githubapp.com" name="octolytics-host" /><meta content="collector-cdn.github.com" name="octolytics-script-host" /><meta content="github" name="octolytics-app-id" /><meta content="32AE799D:1FFA:1EEA08:536606AF" name="octolytics-dimension-request_id" />
    

    
    
    <link rel="icon" type="image/x-icon" href="https://github.global.ssl.fastly.net/favicon.ico" />

    <meta content="authenticity_token" name="csrf-param" />
<meta content="ffcq8PDR2UrTALka+bSs7DOB5/MBFtSi4G9OvTLsTyTv1Nd3/cSl4wd0owY+g+luQVKpRnd1OcX1EtO5DcQTiQ==" name="csrf-token" />

    <link href="https://github.global.ssl.fastly.net/assets/github-825241e13de547a733c8a9cc535c8f6b411b52c1.css" media="all" rel="stylesheet" type="text/css" />
    <link href="https://github.global.ssl.fastly.net/assets/github2-0c03a1f6ffa15e379ec26513a90980fce28e78d9.css" media="all" rel="stylesheet" type="text/css" />
    


        <script crossorigin="anonymous" src="https://github.global.ssl.fastly.net/assets/frameworks-2f6219cf5b1c2bab818848f5705fab73e1f57022.js" type="text/javascript"></script>
        <script async="async" crossorigin="anonymous" src="https://github.global.ssl.fastly.net/assets/github-d72adf5c07eb3ac77dc24e8783e70eb92d281e85.js" type="text/javascript"></script>
        
        
      <meta http-equiv="x-pjax-version" content="dce5aa277a0ef2d852738c9221e0156e">

      
  <meta name="description" content="SurveyParrot Android Application for CS 160" />

  <meta content="3280624" name="octolytics-dimension-user_id" /><meta content="gavinc88" name="octolytics-dimension-user_login" /><meta content="18350875" name="octolytics-dimension-repository_id" /><meta content="gavinc88/SurveyParrot" name="octolytics-dimension-repository_nwo" /><meta content="true" name="octolytics-dimension-repository_public" /><meta content="false" name="octolytics-dimension-repository_is_fork" /><meta content="18350875" name="octolytics-dimension-repository_network_root_id" /><meta content="gavinc88/SurveyParrot" name="octolytics-dimension-repository_network_root_nwo" />
  <link href="https://github.com/gavinc88/SurveyParrot/commits/master.atom" rel="alternate" title="Recent Commits to SurveyParrot:master" type="application/atom+xml" />

  </head>


  <body class="logged_out  env-production windows vis-public page-blob">
    <a href="#start-of-content" tabindex="1" class="accessibility-aid js-skip-to-content">Skip to content</a>
    <div class="wrapper">
      
      
      
      


      
      <div class="header header-logged-out">
  <div class="container clearfix">

    <a class="header-logo-wordmark" href="https://github.com/">
      <span class="mega-octicon octicon-logo-github"></span>
    </a>

    <div class="header-actions">
        <a class="button primary" href="/join">Sign up</a>
      <a class="button signin" href="/login?return_to=%2Fgavinc88%2FSurveyParrot%2Fblob%2Fmaster%2Fsrc%2Fcom%2Fcs160%2Fsurveyparrot%2FChooseSurveyActivity.java">Sign in</a>
    </div>

    <div class="command-bar js-command-bar  in-repository">

      <ul class="top-nav">
          <li class="explore"><a href="/explore">Explore</a></li>
        <li class="features"><a href="/features">Features</a></li>
          <li class="enterprise"><a href="https://enterprise.github.com/">Enterprise</a></li>
          <li class="blog"><a href="/blog">Blog</a></li>
      </ul>
        <form accept-charset="UTF-8" action="/search" class="command-bar-form" id="top_search_form" method="get">

<div class="commandbar">
  <span class="message"></span>
  <input type="text" data-hotkey="s, /" name="q" id="js-command-bar-field" placeholder="Search or type a command" tabindex="1" autocapitalize="off"
    
    
      data-repo="gavinc88/SurveyParrot"
      data-branch="master"
      data-sha="5608091a92ce0aa499566069df1397f3049f13b1"
  >
  <div class="display hidden"></div>
</div>

    <input type="hidden" name="nwo" value="gavinc88/SurveyParrot" />

    <div class="select-menu js-menu-container js-select-menu search-context-select-menu">
      <span class="minibutton select-menu-button js-menu-target" role="button" aria-haspopup="true">
        <span class="js-select-button">This repository</span>
      </span>

      <div class="select-menu-modal-holder js-menu-content js-navigation-container" aria-hidden="true">
        <div class="select-menu-modal">

          <div class="select-menu-item js-navigation-item js-this-repository-navigation-item selected">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" class="js-search-this-repository" name="search_target" value="repository" checked="checked" />
            <div class="select-menu-item-text js-select-button-text">This repository</div>
          </div> <!-- /.select-menu-item -->

          <div class="select-menu-item js-navigation-item js-all-repositories-navigation-item">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" name="search_target" value="global" />
            <div class="select-menu-item-text js-select-button-text">All repositories</div>
          </div> <!-- /.select-menu-item -->

        </div>
      </div>
    </div>

  <span class="help tooltipped tooltipped-s" aria-label="Show command bar help">
    <span class="octicon octicon-question"></span>
  </span>


  <input type="hidden" name="ref" value="cmdform">

</form>
    </div>

  </div>
</div>



      <div id="start-of-content" class="accessibility-aid"></div>
          <div class="site" itemscope itemtype="http://schema.org/WebPage">
    <div id="js-flash-container">
      
    </div>
    <div class="pagehead repohead instapaper_ignore readability-menu">
      <div class="container">
        

<ul class="pagehead-actions">


  <li>
    <a href="/login?return_to=%2Fgavinc88%2FSurveyParrot"
    class="minibutton with-count star-button tooltipped tooltipped-n"
    aria-label="You must be signed in to star a repository" rel="nofollow">
    <span class="octicon octicon-star"></span>Star
  </a>

    <a class="social-count js-social-count" href="/gavinc88/SurveyParrot/stargazers">
      0
    </a>

  </li>

    <li>
      <a href="/login?return_to=%2Fgavinc88%2FSurveyParrot"
        class="minibutton with-count js-toggler-target fork-button tooltipped tooltipped-n"
        aria-label="You must be signed in to fork a repository" rel="nofollow">
        <span class="octicon octicon-git-branch"></span>Fork
      </a>
      <a href="/gavinc88/SurveyParrot/network" class="social-count">
        0
      </a>
    </li>
</ul>

        <h1 itemscope itemtype="http://data-vocabulary.org/Breadcrumb" class="entry-title public">
          <span class="repo-label"><span>public</span></span>
          <span class="mega-octicon octicon-repo"></span>
          <span class="author"><a href="/gavinc88" class="url fn" itemprop="url" rel="author"><span itemprop="title">gavinc88</span></a></span><!--
       --><span class="path-divider">/</span><!--
       --><strong><a href="/gavinc88/SurveyParrot" class="js-current-repository js-repo-home-link">SurveyParrot</a></strong>

          <span class="page-context-loader">
            <img alt="Octocat-spinner-32" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
          </span>

        </h1>
      </div><!-- /.container -->
    </div><!-- /.repohead -->

    <div class="container">
      <div class="repository-with-sidebar repo-container new-discussion-timeline js-new-discussion-timeline  ">
        <div class="repository-sidebar clearfix">
            

<div class="sunken-menu vertical-right repo-nav js-repo-nav js-repository-container-pjax js-octicon-loaders">
  <div class="sunken-menu-contents">
    <ul class="sunken-menu-group">
      <li class="tooltipped tooltipped-w" aria-label="Code">
        <a href="/gavinc88/SurveyParrot" aria-label="Code" class="selected js-selected-navigation-item sunken-menu-item" data-hotkey="g c" data-pjax="true" data-selected-links="repo_source repo_downloads repo_commits repo_releases repo_tags repo_branches /gavinc88/SurveyParrot">
          <span class="octicon octicon-code"></span> <span class="full-word">Code</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

        <li class="tooltipped tooltipped-w" aria-label="Issues">
          <a href="/gavinc88/SurveyParrot/issues" aria-label="Issues" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-hotkey="g i" data-selected-links="repo_issues /gavinc88/SurveyParrot/issues">
            <span class="octicon octicon-issue-opened"></span> <span class="full-word">Issues</span>
            <span class='counter'>0</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>        </li>

      <li class="tooltipped tooltipped-w" aria-label="Pull Requests">
        <a href="/gavinc88/SurveyParrot/pulls" aria-label="Pull Requests" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-hotkey="g p" data-selected-links="repo_pulls /gavinc88/SurveyParrot/pulls">
            <span class="octicon octicon-git-pull-request"></span> <span class="full-word">Pull Requests</span>
            <span class='counter'>0</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>


    </ul>
    <div class="sunken-menu-separator"></div>
    <ul class="sunken-menu-group">

      <li class="tooltipped tooltipped-w" aria-label="Pulse">
        <a href="/gavinc88/SurveyParrot/pulse" aria-label="Pulse" class="js-selected-navigation-item sunken-menu-item" data-pjax="true" data-selected-links="pulse /gavinc88/SurveyParrot/pulse">
          <span class="octicon octicon-pulse"></span> <span class="full-word">Pulse</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

      <li class="tooltipped tooltipped-w" aria-label="Graphs">
        <a href="/gavinc88/SurveyParrot/graphs" aria-label="Graphs" class="js-selected-navigation-item sunken-menu-item" data-pjax="true" data-selected-links="repo_graphs repo_contributors /gavinc88/SurveyParrot/graphs">
          <span class="octicon octicon-graph"></span> <span class="full-word">Graphs</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

      <li class="tooltipped tooltipped-w" aria-label="Network">
        <a href="/gavinc88/SurveyParrot/network" aria-label="Network" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-selected-links="repo_network /gavinc88/SurveyParrot/network">
          <span class="octicon octicon-git-branch"></span> <span class="full-word">Network</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>
    </ul>


  </div>
</div>

              <div class="only-with-full-nav">
                

  

<div class="clone-url open"
  data-protocol-type="http"
  data-url="/users/set_protocol?protocol_selector=http&amp;protocol_type=clone">
  <h3><strong>HTTPS</strong> clone URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="https://github.com/gavinc88/SurveyParrot.git" readonly="readonly">
    <span class="url-box-clippy">
    <button aria-label="copy to clipboard" class="js-zeroclipboard minibutton zeroclipboard-button" data-clipboard-text="https://github.com/gavinc88/SurveyParrot.git" data-copied-hint="copied!" type="button"><span class="octicon octicon-clippy"></span></button>
    </span>
  </div>
</div>

  

<div class="clone-url "
  data-protocol-type="subversion"
  data-url="/users/set_protocol?protocol_selector=subversion&amp;protocol_type=clone">
  <h3><strong>Subversion</strong> checkout URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="https://github.com/gavinc88/SurveyParrot" readonly="readonly">
    <span class="url-box-clippy">
    <button aria-label="copy to clipboard" class="js-zeroclipboard minibutton zeroclipboard-button" data-clipboard-text="https://github.com/gavinc88/SurveyParrot" data-copied-hint="copied!" type="button"><span class="octicon octicon-clippy"></span></button>
    </span>
  </div>
</div>


<p class="clone-options">You can clone with
      <a href="#" class="js-clone-selector" data-protocol="http">HTTPS</a>
      or <a href="#" class="js-clone-selector" data-protocol="subversion">Subversion</a>.
  <span class="help tooltipped tooltipped-n" aria-label="Get help on which URL is right for you.">
    <a href="https://help.github.com/articles/which-remote-url-should-i-use">
    <span class="octicon octicon-question"></span>
    </a>
  </span>
</p>


  <a href="http://windows.github.com" class="minibutton sidebar-button" title="Save gavinc88/SurveyParrot to your computer and use it in GitHub Desktop." aria-label="Save gavinc88/SurveyParrot to your computer and use it in GitHub Desktop.">
    <span class="octicon octicon-device-desktop"></span>
    Clone in Desktop
  </a>

                <a href="/gavinc88/SurveyParrot/archive/master.zip"
                   class="minibutton sidebar-button"
                   aria-label="Download gavinc88/SurveyParrot as a zip file"
                   title="Download gavinc88/SurveyParrot as a zip file"
                   rel="nofollow">
                  <span class="octicon octicon-cloud-download"></span>
                  Download ZIP
                </a>
              </div>
        </div><!-- /.repository-sidebar -->

        <div id="js-repo-pjax-container" class="repository-content context-loader-container" data-pjax-container>
          

<a href="/gavinc88/SurveyParrot/blob/8a31de296f2c31d7d3e0980401c8bfb50fccc3d7/src/com/cs160/surveyparrot/ChooseSurveyActivity.java" class="hidden js-permalink-shortcut" data-hotkey="y">Permalink</a>

<!-- blob contrib key: blob_contributors:v21:6020e2c5af167210a126dae12f324b58 -->

<p title="This is a placeholder element" class="js-history-link-replace hidden"></p>

<a href="/gavinc88/SurveyParrot/find/master" data-pjax data-hotkey="t" class="js-show-file-finder" style="display:none">Show File Finder</a>

<div class="file-navigation">
  

<div class="select-menu js-menu-container js-select-menu" >
  <span class="minibutton select-menu-button js-menu-target" data-hotkey="w"
    data-master-branch="master"
    data-ref="master"
    role="button" aria-label="Switch branches or tags" tabindex="0" aria-haspopup="true">
    <span class="octicon octicon-git-branch"></span>
    <i>branch:</i>
    <span class="js-select-button">master</span>
  </span>

  <div class="select-menu-modal-holder js-menu-content js-navigation-container" data-pjax aria-hidden="true">

    <div class="select-menu-modal">
      <div class="select-menu-header">
        <span class="select-menu-title">Switch branches/tags</span>
        <span class="octicon octicon-remove-close js-menu-close"></span>
      </div> <!-- /.select-menu-header -->

      <div class="select-menu-filters">
        <div class="select-menu-text-filter">
          <input type="text" aria-label="Filter branches/tags" id="context-commitish-filter-field" class="js-filterable-field js-navigation-enable" placeholder="Filter branches/tags">
        </div>
        <div class="select-menu-tabs">
          <ul>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="branches" class="js-select-menu-tab">Branches</a>
            </li>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="tags" class="js-select-menu-tab">Tags</a>
            </li>
          </ul>
        </div><!-- /.select-menu-tabs -->
      </div><!-- /.select-menu-filters -->

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="branches">

        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


            <div class="select-menu-item js-navigation-item selected">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <a href="/gavinc88/SurveyParrot/blob/master/src/com/cs160/surveyparrot/ChooseSurveyActivity.java"
                 data-name="master"
                 data-skip-pjax="true"
                 rel="nofollow"
                 class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target"
                 title="master">master</a>
            </div> <!-- /.select-menu-item -->
        </div>

          <div class="select-menu-no-results">Nothing to show</div>
      </div> <!-- /.select-menu-list -->

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="tags">
        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


        </div>

        <div class="select-menu-no-results">Nothing to show</div>
      </div> <!-- /.select-menu-list -->

    </div> <!-- /.select-menu-modal -->
  </div> <!-- /.select-menu-modal-holder -->
</div> <!-- /.select-menu -->

  <div class="breadcrumb">
    <span class='repo-root js-repo-root'><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/gavinc88/SurveyParrot" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">SurveyParrot</span></a></span></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/gavinc88/SurveyParrot/tree/master/src" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">src</span></a></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/gavinc88/SurveyParrot/tree/master/src/com" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">com</span></a></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/gavinc88/SurveyParrot/tree/master/src/com/cs160" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">cs160</span></a></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/gavinc88/SurveyParrot/tree/master/src/com/cs160/surveyparrot" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">surveyparrot</span></a></span><span class="separator"> / </span><strong class="final-path">ChooseSurveyActivity.java</strong> <button aria-label="copy to clipboard" class="js-zeroclipboard minibutton zeroclipboard-button" data-clipboard-text="src/com/cs160/surveyparrot/ChooseSurveyActivity.java" data-copied-hint="copied!" type="button"><span class="octicon octicon-clippy"></span></button>
  </div>
</div>


  <div class="commit file-history-tease">
    <img alt="lobmeleon" class="main-avatar js-avatar" data-user="5439655" height="24" src="https://avatars0.githubusercontent.com/u/5439655?s=140" width="24" />
    <span class="author"><a href="/lobmeleon" rel="author">lobmeleon</a></span>
    <local-time datetime="2014-05-03T13:47:58-07:00" from="now" title-format="%Y-%m-%d %H:%M:%S %z" title="2014-05-03 13:47:58 -0700">May 03, 2014</local-time>
    <div class="commit-title">
        <a href="/gavinc88/SurveyParrot/commit/8a31de296f2c31d7d3e0980401c8bfb50fccc3d7" class="message" data-pjax="true" title="New Surveys!

Modified our code to allow for multiple surveys to be taken. Selecting
&quot;No&quot; on the ChooseSurveyActivity will cycle through available surveys,
and I&#39;ve added two new surveys.">New Surveys!</a>
    </div>

    <div class="participation">
      <p class="quickstat"><a href="#blob_contributors_box" rel="facebox"><strong>2</strong>  contributors</a></p>
          <a class="avatar tooltipped tooltipped-s" aria-label="gavinc88" href="/gavinc88/SurveyParrot/commits/master/src/com/cs160/surveyparrot/ChooseSurveyActivity.java?author=gavinc88"><img alt="Gavin Chu" class=" js-avatar" data-user="3280624" height="20" src="https://avatars2.githubusercontent.com/u/3280624?s=140" width="20" /></a>
    <a class="avatar tooltipped tooltipped-s" aria-label="lobmeleon" href="/gavinc88/SurveyParrot/commits/master/src/com/cs160/surveyparrot/ChooseSurveyActivity.java?author=lobmeleon"><img alt="lobmeleon" class=" js-avatar" data-user="5439655" height="20" src="https://avatars0.githubusercontent.com/u/5439655?s=140" width="20" /></a>


    </div>
    <div id="blob_contributors_box" style="display:none">
      <h2 class="facebox-header">Users who have contributed to this file</h2>
      <ul class="facebox-user-list">
          <li class="facebox-user-list-item">
            <img alt="Gavin Chu" class=" js-avatar" data-user="3280624" height="24" src="https://avatars2.githubusercontent.com/u/3280624?s=140" width="24" />
            <a href="/gavinc88">gavinc88</a>
          </li>
          <li class="facebox-user-list-item">
            <img alt="lobmeleon" class=" js-avatar" data-user="5439655" height="24" src="https://avatars0.githubusercontent.com/u/5439655?s=140" width="24" />
            <a href="/lobmeleon">lobmeleon</a>
          </li>
      </ul>
    </div>
  </div>

<div class="file-box">
  <div class="file">
    <div class="meta clearfix">
      <div class="info file-name">
        <span class="icon"><b class="octicon octicon-file-text"></b></span>
        <span class="mode" title="File Mode">file</span>
        <span class="meta-divider"></span>
          <span>268 lines (232 sloc)</span>
          <span class="meta-divider"></span>
        <span>8.279 kb</span>
      </div>
      <div class="actions">
        <div class="button-group">
            <a class="minibutton tooltipped tooltipped-w"
               href="http://windows.github.com" aria-label="Open this file in GitHub for Windows">
                <span class="octicon octicon-device-desktop"></span> Open
            </a>
              <a class="minibutton disabled tooltipped tooltipped-w" href="#"
                 aria-label="You must be signed in to make or propose changes">Edit</a>
          <a href="/gavinc88/SurveyParrot/raw/master/src/com/cs160/surveyparrot/ChooseSurveyActivity.java" class="button minibutton " id="raw-url">Raw</a>
            <a href="/gavinc88/SurveyParrot/blame/master/src/com/cs160/surveyparrot/ChooseSurveyActivity.java" class="button minibutton js-update-url-with-hash">Blame</a>
          <a href="/gavinc88/SurveyParrot/commits/master/src/com/cs160/surveyparrot/ChooseSurveyActivity.java" class="button minibutton " rel="nofollow">History</a>
        </div><!-- /.button-group -->
          <a class="minibutton danger disabled empty-icon tooltipped tooltipped-w" href="#"
             aria-label="You must be signed in to make or propose changes">
          Delete
        </a>
      </div><!-- /.actions -->
    </div>
        <div class="blob-wrapper data type-java js-blob-data">
        <table class="file-code file-diff tab-size-8">
          <tr class="file-code-line">
            <td class="blob-line-nums">
              <span id="L1" rel="#L1">1</span>
<span id="L2" rel="#L2">2</span>
<span id="L3" rel="#L3">3</span>
<span id="L4" rel="#L4">4</span>
<span id="L5" rel="#L5">5</span>
<span id="L6" rel="#L6">6</span>
<span id="L7" rel="#L7">7</span>
<span id="L8" rel="#L8">8</span>
<span id="L9" rel="#L9">9</span>
<span id="L10" rel="#L10">10</span>
<span id="L11" rel="#L11">11</span>
<span id="L12" rel="#L12">12</span>
<span id="L13" rel="#L13">13</span>
<span id="L14" rel="#L14">14</span>
<span id="L15" rel="#L15">15</span>
<span id="L16" rel="#L16">16</span>
<span id="L17" rel="#L17">17</span>
<span id="L18" rel="#L18">18</span>
<span id="L19" rel="#L19">19</span>
<span id="L20" rel="#L20">20</span>
<span id="L21" rel="#L21">21</span>
<span id="L22" rel="#L22">22</span>
<span id="L23" rel="#L23">23</span>
<span id="L24" rel="#L24">24</span>
<span id="L25" rel="#L25">25</span>
<span id="L26" rel="#L26">26</span>
<span id="L27" rel="#L27">27</span>
<span id="L28" rel="#L28">28</span>
<span id="L29" rel="#L29">29</span>
<span id="L30" rel="#L30">30</span>
<span id="L31" rel="#L31">31</span>
<span id="L32" rel="#L32">32</span>
<span id="L33" rel="#L33">33</span>
<span id="L34" rel="#L34">34</span>
<span id="L35" rel="#L35">35</span>
<span id="L36" rel="#L36">36</span>
<span id="L37" rel="#L37">37</span>
<span id="L38" rel="#L38">38</span>
<span id="L39" rel="#L39">39</span>
<span id="L40" rel="#L40">40</span>
<span id="L41" rel="#L41">41</span>
<span id="L42" rel="#L42">42</span>
<span id="L43" rel="#L43">43</span>
<span id="L44" rel="#L44">44</span>
<span id="L45" rel="#L45">45</span>
<span id="L46" rel="#L46">46</span>
<span id="L47" rel="#L47">47</span>
<span id="L48" rel="#L48">48</span>
<span id="L49" rel="#L49">49</span>
<span id="L50" rel="#L50">50</span>
<span id="L51" rel="#L51">51</span>
<span id="L52" rel="#L52">52</span>
<span id="L53" rel="#L53">53</span>
<span id="L54" rel="#L54">54</span>
<span id="L55" rel="#L55">55</span>
<span id="L56" rel="#L56">56</span>
<span id="L57" rel="#L57">57</span>
<span id="L58" rel="#L58">58</span>
<span id="L59" rel="#L59">59</span>
<span id="L60" rel="#L60">60</span>
<span id="L61" rel="#L61">61</span>
<span id="L62" rel="#L62">62</span>
<span id="L63" rel="#L63">63</span>
<span id="L64" rel="#L64">64</span>
<span id="L65" rel="#L65">65</span>
<span id="L66" rel="#L66">66</span>
<span id="L67" rel="#L67">67</span>
<span id="L68" rel="#L68">68</span>
<span id="L69" rel="#L69">69</span>
<span id="L70" rel="#L70">70</span>
<span id="L71" rel="#L71">71</span>
<span id="L72" rel="#L72">72</span>
<span id="L73" rel="#L73">73</span>
<span id="L74" rel="#L74">74</span>
<span id="L75" rel="#L75">75</span>
<span id="L76" rel="#L76">76</span>
<span id="L77" rel="#L77">77</span>
<span id="L78" rel="#L78">78</span>
<span id="L79" rel="#L79">79</span>
<span id="L80" rel="#L80">80</span>
<span id="L81" rel="#L81">81</span>
<span id="L82" rel="#L82">82</span>
<span id="L83" rel="#L83">83</span>
<span id="L84" rel="#L84">84</span>
<span id="L85" rel="#L85">85</span>
<span id="L86" rel="#L86">86</span>
<span id="L87" rel="#L87">87</span>
<span id="L88" rel="#L88">88</span>
<span id="L89" rel="#L89">89</span>
<span id="L90" rel="#L90">90</span>
<span id="L91" rel="#L91">91</span>
<span id="L92" rel="#L92">92</span>
<span id="L93" rel="#L93">93</span>
<span id="L94" rel="#L94">94</span>
<span id="L95" rel="#L95">95</span>
<span id="L96" rel="#L96">96</span>
<span id="L97" rel="#L97">97</span>
<span id="L98" rel="#L98">98</span>
<span id="L99" rel="#L99">99</span>
<span id="L100" rel="#L100">100</span>
<span id="L101" rel="#L101">101</span>
<span id="L102" rel="#L102">102</span>
<span id="L103" rel="#L103">103</span>
<span id="L104" rel="#L104">104</span>
<span id="L105" rel="#L105">105</span>
<span id="L106" rel="#L106">106</span>
<span id="L107" rel="#L107">107</span>
<span id="L108" rel="#L108">108</span>
<span id="L109" rel="#L109">109</span>
<span id="L110" rel="#L110">110</span>
<span id="L111" rel="#L111">111</span>
<span id="L112" rel="#L112">112</span>
<span id="L113" rel="#L113">113</span>
<span id="L114" rel="#L114">114</span>
<span id="L115" rel="#L115">115</span>
<span id="L116" rel="#L116">116</span>
<span id="L117" rel="#L117">117</span>
<span id="L118" rel="#L118">118</span>
<span id="L119" rel="#L119">119</span>
<span id="L120" rel="#L120">120</span>
<span id="L121" rel="#L121">121</span>
<span id="L122" rel="#L122">122</span>
<span id="L123" rel="#L123">123</span>
<span id="L124" rel="#L124">124</span>
<span id="L125" rel="#L125">125</span>
<span id="L126" rel="#L126">126</span>
<span id="L127" rel="#L127">127</span>
<span id="L128" rel="#L128">128</span>
<span id="L129" rel="#L129">129</span>
<span id="L130" rel="#L130">130</span>
<span id="L131" rel="#L131">131</span>
<span id="L132" rel="#L132">132</span>
<span id="L133" rel="#L133">133</span>
<span id="L134" rel="#L134">134</span>
<span id="L135" rel="#L135">135</span>
<span id="L136" rel="#L136">136</span>
<span id="L137" rel="#L137">137</span>
<span id="L138" rel="#L138">138</span>
<span id="L139" rel="#L139">139</span>
<span id="L140" rel="#L140">140</span>
<span id="L141" rel="#L141">141</span>
<span id="L142" rel="#L142">142</span>
<span id="L143" rel="#L143">143</span>
<span id="L144" rel="#L144">144</span>
<span id="L145" rel="#L145">145</span>
<span id="L146" rel="#L146">146</span>
<span id="L147" rel="#L147">147</span>
<span id="L148" rel="#L148">148</span>
<span id="L149" rel="#L149">149</span>
<span id="L150" rel="#L150">150</span>
<span id="L151" rel="#L151">151</span>
<span id="L152" rel="#L152">152</span>
<span id="L153" rel="#L153">153</span>
<span id="L154" rel="#L154">154</span>
<span id="L155" rel="#L155">155</span>
<span id="L156" rel="#L156">156</span>
<span id="L157" rel="#L157">157</span>
<span id="L158" rel="#L158">158</span>
<span id="L159" rel="#L159">159</span>
<span id="L160" rel="#L160">160</span>
<span id="L161" rel="#L161">161</span>
<span id="L162" rel="#L162">162</span>
<span id="L163" rel="#L163">163</span>
<span id="L164" rel="#L164">164</span>
<span id="L165" rel="#L165">165</span>
<span id="L166" rel="#L166">166</span>
<span id="L167" rel="#L167">167</span>
<span id="L168" rel="#L168">168</span>
<span id="L169" rel="#L169">169</span>
<span id="L170" rel="#L170">170</span>
<span id="L171" rel="#L171">171</span>
<span id="L172" rel="#L172">172</span>
<span id="L173" rel="#L173">173</span>
<span id="L174" rel="#L174">174</span>
<span id="L175" rel="#L175">175</span>
<span id="L176" rel="#L176">176</span>
<span id="L177" rel="#L177">177</span>
<span id="L178" rel="#L178">178</span>
<span id="L179" rel="#L179">179</span>
<span id="L180" rel="#L180">180</span>
<span id="L181" rel="#L181">181</span>
<span id="L182" rel="#L182">182</span>
<span id="L183" rel="#L183">183</span>
<span id="L184" rel="#L184">184</span>
<span id="L185" rel="#L185">185</span>
<span id="L186" rel="#L186">186</span>
<span id="L187" rel="#L187">187</span>
<span id="L188" rel="#L188">188</span>
<span id="L189" rel="#L189">189</span>
<span id="L190" rel="#L190">190</span>
<span id="L191" rel="#L191">191</span>
<span id="L192" rel="#L192">192</span>
<span id="L193" rel="#L193">193</span>
<span id="L194" rel="#L194">194</span>
<span id="L195" rel="#L195">195</span>
<span id="L196" rel="#L196">196</span>
<span id="L197" rel="#L197">197</span>
<span id="L198" rel="#L198">198</span>
<span id="L199" rel="#L199">199</span>
<span id="L200" rel="#L200">200</span>
<span id="L201" rel="#L201">201</span>
<span id="L202" rel="#L202">202</span>
<span id="L203" rel="#L203">203</span>
<span id="L204" rel="#L204">204</span>
<span id="L205" rel="#L205">205</span>
<span id="L206" rel="#L206">206</span>
<span id="L207" rel="#L207">207</span>
<span id="L208" rel="#L208">208</span>
<span id="L209" rel="#L209">209</span>
<span id="L210" rel="#L210">210</span>
<span id="L211" rel="#L211">211</span>
<span id="L212" rel="#L212">212</span>
<span id="L213" rel="#L213">213</span>
<span id="L214" rel="#L214">214</span>
<span id="L215" rel="#L215">215</span>
<span id="L216" rel="#L216">216</span>
<span id="L217" rel="#L217">217</span>
<span id="L218" rel="#L218">218</span>
<span id="L219" rel="#L219">219</span>
<span id="L220" rel="#L220">220</span>
<span id="L221" rel="#L221">221</span>
<span id="L222" rel="#L222">222</span>
<span id="L223" rel="#L223">223</span>
<span id="L224" rel="#L224">224</span>
<span id="L225" rel="#L225">225</span>
<span id="L226" rel="#L226">226</span>
<span id="L227" rel="#L227">227</span>
<span id="L228" rel="#L228">228</span>
<span id="L229" rel="#L229">229</span>
<span id="L230" rel="#L230">230</span>
<span id="L231" rel="#L231">231</span>
<span id="L232" rel="#L232">232</span>
<span id="L233" rel="#L233">233</span>
<span id="L234" rel="#L234">234</span>
<span id="L235" rel="#L235">235</span>
<span id="L236" rel="#L236">236</span>
<span id="L237" rel="#L237">237</span>
<span id="L238" rel="#L238">238</span>
<span id="L239" rel="#L239">239</span>
<span id="L240" rel="#L240">240</span>
<span id="L241" rel="#L241">241</span>
<span id="L242" rel="#L242">242</span>
<span id="L243" rel="#L243">243</span>
<span id="L244" rel="#L244">244</span>
<span id="L245" rel="#L245">245</span>
<span id="L246" rel="#L246">246</span>
<span id="L247" rel="#L247">247</span>
<span id="L248" rel="#L248">248</span>
<span id="L249" rel="#L249">249</span>
<span id="L250" rel="#L250">250</span>
<span id="L251" rel="#L251">251</span>
<span id="L252" rel="#L252">252</span>
<span id="L253" rel="#L253">253</span>
<span id="L254" rel="#L254">254</span>
<span id="L255" rel="#L255">255</span>
<span id="L256" rel="#L256">256</span>
<span id="L257" rel="#L257">257</span>
<span id="L258" rel="#L258">258</span>
<span id="L259" rel="#L259">259</span>
<span id="L260" rel="#L260">260</span>
<span id="L261" rel="#L261">261</span>
<span id="L262" rel="#L262">262</span>
<span id="L263" rel="#L263">263</span>
<span id="L264" rel="#L264">264</span>
<span id="L265" rel="#L265">265</span>
<span id="L266" rel="#L266">266</span>
<span id="L267" rel="#L267">267</span>

            </td>
            <td class="blob-line-code"><div class="code-body highlight"><pre><div class='line' id='LC1'><span class="kn">package</span> <span class="n">com</span><span class="o">.</span><span class="na">cs160</span><span class="o">.</span><span class="na">surveyparrot</span><span class="o">;</span></div><div class='line' id='LC2'><br/></div><div class='line' id='LC3'><span class="kn">import</span> <span class="nn">java.io.IOException</span><span class="o">;</span></div><div class='line' id='LC4'><span class="kn">import</span> <span class="nn">java.util.ArrayList</span><span class="o">;</span></div><div class='line' id='LC5'><span class="kn">import</span> <span class="nn">java.util.HashMap</span><span class="o">;</span></div><div class='line' id='LC6'><span class="kn">import</span> <span class="nn">java.util.Locale</span><span class="o">;</span></div><div class='line' id='LC7'><br/></div><div class='line' id='LC8'><span class="kn">import</span> <span class="nn">android.annotation.SuppressLint</span><span class="o">;</span></div><div class='line' id='LC9'><span class="kn">import</span> <span class="nn">android.app.Activity</span><span class="o">;</span></div><div class='line' id='LC10'><span class="kn">import</span> <span class="nn">android.content.Context</span><span class="o">;</span></div><div class='line' id='LC11'><span class="kn">import</span> <span class="nn">android.content.Intent</span><span class="o">;</span></div><div class='line' id='LC12'><span class="kn">import</span> <span class="nn">android.media.AudioManager</span><span class="o">;</span></div><div class='line' id='LC13'><span class="kn">import</span> <span class="nn">android.media.MediaPlayer</span><span class="o">;</span></div><div class='line' id='LC14'><span class="kn">import</span> <span class="nn">android.media.RingtoneManager</span><span class="o">;</span></div><div class='line' id='LC15'><span class="kn">import</span> <span class="nn">android.net.Uri</span><span class="o">;</span></div><div class='line' id='LC16'><span class="kn">import</span> <span class="nn">android.os.Build</span><span class="o">;</span></div><div class='line' id='LC17'><span class="kn">import</span> <span class="nn">android.os.Bundle</span><span class="o">;</span></div><div class='line' id='LC18'><span class="kn">import</span> <span class="nn">android.speech.RecognitionListener</span><span class="o">;</span></div><div class='line' id='LC19'><span class="kn">import</span> <span class="nn">android.speech.RecognizerIntent</span><span class="o">;</span></div><div class='line' id='LC20'><span class="kn">import</span> <span class="nn">android.speech.SpeechRecognizer</span><span class="o">;</span></div><div class='line' id='LC21'><span class="kn">import</span> <span class="nn">android.speech.tts.TextToSpeech</span><span class="o">;</span></div><div class='line' id='LC22'><span class="kn">import</span> <span class="nn">android.speech.tts.UtteranceProgressListener</span><span class="o">;</span></div><div class='line' id='LC23'><span class="kn">import</span> <span class="nn">android.speech.tts.TextToSpeech.OnUtteranceCompletedListener</span><span class="o">;</span></div><div class='line' id='LC24'><span class="kn">import</span> <span class="nn">android.util.Log</span><span class="o">;</span></div><div class='line' id='LC25'><span class="kn">import</span> <span class="nn">android.view.View</span><span class="o">;</span></div><div class='line' id='LC26'><span class="kn">import</span> <span class="nn">android.view.View.OnClickListener</span><span class="o">;</span></div><div class='line' id='LC27'><span class="kn">import</span> <span class="nn">android.widget.Button</span><span class="o">;</span></div><div class='line' id='LC28'><span class="kn">import</span> <span class="nn">android.widget.TextView</span><span class="o">;</span></div><div class='line' id='LC29'><br/></div><div class='line' id='LC30'><span class="kd">public</span> <span class="kd">class</span> <span class="nc">ChooseSurveyActivity</span> <span class="kd">extends</span> <span class="n">Activity</span> <span class="kd">implements</span> <span class="n">OnClickListener</span><span class="o">,</span> <span class="n">RecognitionListener</span><span class="o">,</span> <span class="n">TextToSpeech</span><span class="o">.</span><span class="na">OnInitListener</span> <span class="o">{</span></div><div class='line' id='LC31'><br/></div><div class='line' id='LC32'>	<span class="kd">private</span> <span class="n">Button</span> <span class="n">yes</span><span class="o">,</span> <span class="n">no</span><span class="o">;</span></div><div class='line' id='LC33'>	<span class="kd">private</span> <span class="n">TextView</span> <span class="n">surveyNameTextView</span><span class="o">;</span></div><div class='line' id='LC34'>	<span class="kd">private</span> <span class="n">String</span> <span class="n">surveyName</span><span class="o">;</span></div><div class='line' id='LC35'><br/></div><div class='line' id='LC36'>	<span class="kd">private</span> <span class="n">SpeechRecognizer</span> <span class="n">sr</span><span class="o">;</span></div><div class='line' id='LC37'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">TextToSpeech</span> <span class="n">tts</span><span class="o">;</span></div><div class='line' id='LC38'><br/></div><div class='line' id='LC39'>	<span class="nd">@Override</span></div><div class='line' id='LC40'>	<span class="kd">protected</span> <span class="kt">void</span> <span class="nf">onCreate</span><span class="o">(</span><span class="n">Bundle</span> <span class="n">savedInstanceState</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC41'>		<span class="kd">super</span><span class="o">.</span><span class="na">onCreate</span><span class="o">(</span><span class="n">savedInstanceState</span><span class="o">);</span></div><div class='line' id='LC42'>		<span class="n">setContentView</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">layout</span><span class="o">.</span><span class="na">activity_choose_survey</span><span class="o">);</span></div><div class='line' id='LC43'><br/></div><div class='line' id='LC44'>		<span class="n">fetchSurvey</span><span class="o">();</span></div><div class='line' id='LC45'><br/></div><div class='line' id='LC46'>		<span class="n">sr</span> <span class="o">=</span> <span class="n">SpeechRecognizer</span><span class="o">.</span><span class="na">createSpeechRecognizer</span><span class="o">(</span><span class="k">this</span><span class="o">);</span></div><div class='line' id='LC47'>		<span class="n">sr</span><span class="o">.</span><span class="na">setRecognitionListener</span><span class="o">(</span><span class="k">this</span><span class="o">);</span></div><div class='line' id='LC48'>		<span class="n">tts</span> <span class="o">=</span> <span class="k">new</span> <span class="n">TextToSpeech</span><span class="o">(</span><span class="k">this</span><span class="o">,</span> <span class="k">this</span><span class="o">);</span></div><div class='line' id='LC49'><br/></div><div class='line' id='LC50'>		<span class="n">yes</span> <span class="o">=</span> <span class="o">(</span><span class="n">Button</span><span class="o">)</span> <span class="n">findViewById</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">id</span><span class="o">.</span><span class="na">bYes</span><span class="o">);</span></div><div class='line' id='LC51'>		<span class="n">yes</span><span class="o">.</span><span class="na">setOnClickListener</span><span class="o">(</span><span class="k">this</span><span class="o">);</span></div><div class='line' id='LC52'>		<span class="n">no</span> <span class="o">=</span> <span class="o">(</span><span class="n">Button</span><span class="o">)</span> <span class="n">findViewById</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">id</span><span class="o">.</span><span class="na">bNo</span><span class="o">);</span></div><div class='line' id='LC53'>		<span class="n">no</span><span class="o">.</span><span class="na">setOnClickListener</span><span class="o">(</span><span class="k">this</span><span class="o">);</span></div><div class='line' id='LC54'>		<span class="n">surveyNameTextView</span> <span class="o">=</span> <span class="o">(</span><span class="n">TextView</span><span class="o">)</span> <span class="n">findViewById</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">id</span><span class="o">.</span><span class="na">surveyName</span><span class="o">);</span></div><div class='line' id='LC55'>		<span class="n">surveyNameTextView</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="n">surveyName</span><span class="o">);</span>		</div><div class='line' id='LC56'>	<span class="o">}</span></div><div class='line' id='LC57'><br/></div><div class='line' id='LC58'>	<span class="nd">@Override</span></div><div class='line' id='LC59'>	<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onClick</span><span class="o">(</span><span class="n">View</span> <span class="n">v</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC60'>		<span class="k">switch</span><span class="o">(</span><span class="n">v</span><span class="o">.</span><span class="na">getId</span><span class="o">()){</span></div><div class='line' id='LC61'>		<span class="k">case</span> <span class="n">R</span><span class="o">.</span><span class="na">id</span><span class="o">.</span><span class="na">bYes</span><span class="o">:</span></div><div class='line' id='LC62'>			<span class="n">Intent</span> <span class="n">startSurvey</span> <span class="o">=</span> <span class="k">new</span> <span class="n">Intent</span><span class="o">(</span><span class="k">this</span><span class="o">,</span> <span class="n">SurveyActivity</span><span class="o">.</span><span class="na">class</span><span class="o">);</span></div><div class='line' id='LC63'>			<span class="n">startSurvey</span><span class="o">.</span><span class="na">putExtra</span><span class="o">(</span><span class="s">&quot;survey&quot;</span><span class="o">,</span> <span class="n">surveyName</span><span class="o">);</span></div><div class='line' id='LC64'>			<span class="n">startSurvey</span><span class="o">.</span><span class="na">putExtra</span><span class="o">(</span><span class="s">&quot;questionNumber&quot;</span><span class="o">,</span> <span class="mi">1</span><span class="o">);</span></div><div class='line' id='LC65'>	        <span class="n">startActivity</span><span class="o">(</span><span class="n">startSurvey</span><span class="o">);</span></div><div class='line' id='LC66'>	        <span class="n">finish</span><span class="o">();</span></div><div class='line' id='LC67'>			<span class="k">break</span><span class="o">;</span></div><div class='line' id='LC68'>		<span class="k">case</span> <span class="n">R</span><span class="o">.</span><span class="na">id</span><span class="o">.</span><span class="na">bNo</span><span class="o">:</span></div><div class='line' id='LC69'>			<span class="n">loadNewSurvey</span><span class="o">();</span></div><div class='line' id='LC70'>			<span class="k">break</span><span class="o">;</span></div><div class='line' id='LC71'>		<span class="o">}</span></div><div class='line' id='LC72'>	<span class="o">}</span></div><div class='line' id='LC73'><br/></div><div class='line' id='LC74'>	<span class="kd">private</span> <span class="kt">void</span> <span class="nf">fetchSurvey</span><span class="o">(){</span></div><div class='line' id='LC75'>		<span class="n">surveyName</span> <span class="o">=</span> <span class="n">Survey</span><span class="o">.</span><span class="na">surveys</span><span class="o">.</span><span class="na">get</span><span class="o">(</span><span class="n">SurveyActivity</span><span class="o">.</span><span class="na">surveyId</span><span class="o">).</span><span class="na">name</span><span class="o">;</span></div><div class='line' id='LC76'>	<span class="o">}</span></div><div class='line' id='LC77'><br/></div><div class='line' id='LC78'>	<span class="kd">private</span> <span class="kt">void</span> <span class="nf">loadNewSurvey</span><span class="o">(){</span></div><div class='line' id='LC79'>	    <span class="n">SurveyActivity</span><span class="o">.</span><span class="na">surveyId</span> <span class="o">+=</span> <span class="mi">1</span><span class="o">;</span></div><div class='line' id='LC80'>	    <span class="k">if</span> <span class="o">(</span><span class="n">SurveyActivity</span><span class="o">.</span><span class="na">surveyId</span> <span class="o">&gt;=</span> <span class="n">Survey</span><span class="o">.</span><span class="na">surveys</span><span class="o">.</span><span class="na">size</span><span class="o">())</span> <span class="o">{</span></div><div class='line' id='LC81'>	        <span class="n">SurveyActivity</span><span class="o">.</span><span class="na">surveyId</span> <span class="o">=</span> <span class="mi">0</span><span class="o">;</span></div><div class='line' id='LC82'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">Intent</span> <span class="n">home</span> <span class="o">=</span> <span class="k">new</span> <span class="n">Intent</span><span class="o">(</span><span class="k">this</span><span class="o">,</span> <span class="n">MainActivity</span><span class="o">.</span><span class="na">class</span><span class="o">);</span></div><div class='line' id='LC83'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">startActivity</span><span class="o">(</span><span class="n">home</span><span class="o">);</span></div><div class='line' id='LC84'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">finish</span><span class="o">();</span></div><div class='line' id='LC85'>	    <span class="o">}</span> <span class="k">else</span> <span class="o">{</span></div><div class='line' id='LC86'>	        <span class="n">fetchSurvey</span><span class="o">();</span></div><div class='line' id='LC87'>	        <span class="n">surveyNameTextView</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="n">surveyName</span><span class="o">);</span>     </div><div class='line' id='LC88'>	        <span class="n">read</span><span class="o">();</span></div><div class='line' id='LC89'>	    <span class="o">}</span></div><div class='line' id='LC90'>	<span class="o">}</span></div><div class='line' id='LC91'><br/></div><div class='line' id='LC92'>	<span class="nd">@SuppressLint</span><span class="o">(</span><span class="s">&quot;NewApi&quot;</span><span class="o">)</span></div><div class='line' id='LC93'>	<span class="nd">@SuppressWarnings</span><span class="o">(</span><span class="s">&quot;deprecation&quot;</span><span class="o">)</span></div><div class='line' id='LC94'>	<span class="nd">@Override</span></div><div class='line' id='LC95'>	<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onInit</span><span class="o">(</span><span class="kt">int</span> <span class="n">status</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC96'>		<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;initializing tts&quot;</span><span class="o">);</span></div><div class='line' id='LC97'>		<span class="k">if</span> <span class="o">(</span><span class="n">status</span> <span class="o">==</span> <span class="n">TextToSpeech</span><span class="o">.</span><span class="na">SUCCESS</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC98'>			<span class="k">if</span> <span class="o">(</span><span class="n">Build</span><span class="o">.</span><span class="na">VERSION</span><span class="o">.</span><span class="na">SDK_INT</span> <span class="o">&gt;=</span> <span class="mi">15</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC99'>				<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;set utternace progress listener&quot;</span><span class="o">);</span></div><div class='line' id='LC100'>				<span class="n">tts</span><span class="o">.</span><span class="na">setOnUtteranceProgressListener</span><span class="o">(</span><span class="k">new</span> <span class="n">UtteranceProgressListener</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC101'>					<span class="nd">@Override</span></div><div class='line' id='LC102'>					<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onDone</span><span class="o">(</span><span class="n">String</span> <span class="n">utteranceId</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC103'>						<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;utterance progress onDone&quot;</span><span class="o">);</span></div><div class='line' id='LC104'>						<span class="n">runOnUiThread</span><span class="o">(</span><span class="k">new</span> <span class="n">Runnable</span><span class="o">(){</span></div><div class='line' id='LC105'>							<span class="nd">@Override</span></div><div class='line' id='LC106'>							<span class="kd">public</span> <span class="kt">void</span> <span class="nf">run</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC107'>								<span class="n">listen</span><span class="o">();</span></div><div class='line' id='LC108'>							<span class="o">}</span></div><div class='line' id='LC109'>						<span class="o">});</span></div><div class='line' id='LC110'>					<span class="o">}</span></div><div class='line' id='LC111'><br/></div><div class='line' id='LC112'>					<span class="nd">@Override</span></div><div class='line' id='LC113'>					<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onError</span><span class="o">(</span><span class="n">String</span> <span class="n">utteranceId</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC114'>						<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;utterance progress onError&quot;</span><span class="o">);</span></div><div class='line' id='LC115'>					<span class="o">}</span></div><div class='line' id='LC116'><br/></div><div class='line' id='LC117'>					<span class="nd">@Override</span></div><div class='line' id='LC118'>					<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onStart</span><span class="o">(</span><span class="n">String</span> <span class="n">utteranceId</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC119'>						<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;utterance progress onStart&quot;</span><span class="o">);</span></div><div class='line' id='LC120'>					<span class="o">}</span></div><div class='line' id='LC121'>				<span class="o">});</span></div><div class='line' id='LC122'>			<span class="o">}</span> <span class="k">else</span> <span class="o">{</span></div><div class='line' id='LC123'>				<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;set utternace completed listener&quot;</span><span class="o">);</span></div><div class='line' id='LC124'>				<span class="n">tts</span><span class="o">.</span><span class="na">setOnUtteranceCompletedListener</span><span class="o">(</span><span class="k">new</span> <span class="n">OnUtteranceCompletedListener</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC125'>					<span class="nd">@Override</span></div><div class='line' id='LC126'>					<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onUtteranceCompleted</span><span class="o">(</span><span class="n">String</span> <span class="n">utteranceId</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC127'>						<span class="n">runOnUiThread</span><span class="o">(</span><span class="k">new</span> <span class="n">Runnable</span><span class="o">(){</span></div><div class='line' id='LC128'>							<span class="nd">@Override</span></div><div class='line' id='LC129'>							<span class="kd">public</span> <span class="kt">void</span> <span class="nf">run</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC130'>								<span class="n">listen</span><span class="o">();</span></div><div class='line' id='LC131'>							<span class="o">}</span></div><div class='line' id='LC132'>						<span class="o">});</span></div><div class='line' id='LC133'>					<span class="o">}</span></div><div class='line' id='LC134'>				<span class="o">});</span></div><div class='line' id='LC135'>			<span class="o">}</span></div><div class='line' id='LC136'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">tts</span><span class="o">.</span><span class="na">setLanguage</span><span class="o">(</span><span class="n">Locale</span><span class="o">.</span><span class="na">US</span><span class="o">);</span></div><div class='line' id='LC137'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">tts</span><span class="o">.</span><span class="na">setPitch</span><span class="o">(</span><span class="mf">1.0f</span><span class="o">);</span></div><div class='line' id='LC138'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;Initilization Complete!&quot;</span><span class="o">);</span></div><div class='line' id='LC139'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">read</span><span class="o">();</span></div><div class='line' id='LC140'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span> <span class="k">else</span> <span class="o">{</span></div><div class='line' id='LC141'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;Initilization Failed!&quot;</span><span class="o">);</span></div><div class='line' id='LC142'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC143'>	<span class="o">}</span></div><div class='line' id='LC144'><br/></div><div class='line' id='LC145'>	<span class="kd">public</span> <span class="kt">void</span> <span class="nf">stopSpeechProcesses</span><span class="o">(){</span></div><div class='line' id='LC146'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(</span><span class="n">tts</span> <span class="o">!=</span> <span class="kc">null</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC147'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">tts</span><span class="o">.</span><span class="na">stop</span><span class="o">();</span></div><div class='line' id='LC148'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">tts</span><span class="o">.</span><span class="na">shutdown</span><span class="o">();</span></div><div class='line' id='LC149'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC150'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">sr</span><span class="o">.</span><span class="na">destroy</span><span class="o">();</span></div><div class='line' id='LC151'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC152'><br/></div><div class='line' id='LC153'>	<span class="nd">@Override</span></div><div class='line' id='LC154'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onDestroy</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC155'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Don&#39;t forget to shutdown TTS and SpeechRecognizer!</span></div><div class='line' id='LC156'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">stopSpeechProcesses</span><span class="o">();</span></div><div class='line' id='LC157'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">super</span><span class="o">.</span><span class="na">onDestroy</span><span class="o">();</span></div><div class='line' id='LC158'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC159'><br/></div><div class='line' id='LC160'>	<span class="kd">public</span> <span class="kt">void</span> <span class="nf">read</span><span class="o">(){</span></div><div class='line' id='LC161'>		<span class="n">String</span> <span class="n">input</span> <span class="o">=</span> <span class="s">&quot;Would you like to take a survey on &quot;</span> <span class="o">+</span> <span class="n">surveyName</span><span class="o">;</span></div><div class='line' id='LC162'>		<span class="n">HashMap</span><span class="o">&lt;</span><span class="n">String</span><span class="o">,</span> <span class="n">String</span><span class="o">&gt;</span> <span class="n">hashTts</span> <span class="o">=</span> <span class="k">new</span> <span class="n">HashMap</span><span class="o">&lt;</span><span class="n">String</span><span class="o">,</span> <span class="n">String</span><span class="o">&gt;();</span></div><div class='line' id='LC163'>	    <span class="n">hashTts</span><span class="o">.</span><span class="na">put</span><span class="o">(</span><span class="n">TextToSpeech</span><span class="o">.</span><span class="na">Engine</span><span class="o">.</span><span class="na">KEY_PARAM_UTTERANCE_ID</span><span class="o">,</span> <span class="s">&quot;read_id&quot;</span><span class="o">);</span></div><div class='line' id='LC164'>	    <span class="n">tts</span><span class="o">.</span><span class="na">speak</span><span class="o">(</span><span class="n">input</span><span class="o">,</span> <span class="n">TextToSpeech</span><span class="o">.</span><span class="na">QUEUE_FLUSH</span><span class="o">,</span> <span class="n">hashTts</span><span class="o">);</span></div><div class='line' id='LC165'>	<span class="o">}</span></div><div class='line' id='LC166'><br/></div><div class='line' id='LC167'>	<span class="kd">public</span> <span class="kt">void</span> <span class="nf">listen</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC168'>		<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;listening...&quot;</span><span class="o">);</span></div><div class='line' id='LC169'>		<span class="n">Intent</span> <span class="n">intent</span> <span class="o">=</span> <span class="k">new</span> <span class="n">Intent</span><span class="o">(</span><span class="n">RecognizerIntent</span><span class="o">.</span><span class="na">ACTION_RECOGNIZE_SPEECH</span><span class="o">);</span></div><div class='line' id='LC170'>		<span class="n">intent</span><span class="o">.</span><span class="na">putExtra</span><span class="o">(</span><span class="n">RecognizerIntent</span><span class="o">.</span><span class="na">EXTRA_LANGUAGE_MODEL</span><span class="o">,</span> <span class="n">RecognizerIntent</span><span class="o">.</span><span class="na">LANGUAGE_MODEL_FREE_FORM</span><span class="o">);</span></div><div class='line' id='LC171'>		<span class="n">intent</span><span class="o">.</span><span class="na">putExtra</span><span class="o">(</span><span class="n">RecognizerIntent</span><span class="o">.</span><span class="na">EXTRA_CALLING_PACKAGE</span><span class="o">,</span> <span class="s">&quot;com.cs160.surveyparrot&quot;</span><span class="o">);</span></div><div class='line' id='LC172'>		<span class="c1">//intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 5000);</span></div><div class='line' id='LC173'>		<span class="n">intent</span><span class="o">.</span><span class="na">putExtra</span><span class="o">(</span><span class="n">RecognizerIntent</span><span class="o">.</span><span class="na">EXTRA_MAX_RESULTS</span><span class="o">,</span> <span class="mi">5</span><span class="o">);</span></div><div class='line' id='LC174'>		<span class="n">sr</span><span class="o">.</span><span class="na">startListening</span><span class="o">(</span><span class="n">intent</span><span class="o">);</span></div><div class='line' id='LC175'><br/></div><div class='line' id='LC176'>		<span class="k">if</span><span class="o">(</span><span class="n">Build</span><span class="o">.</span><span class="na">VERSION</span><span class="o">.</span><span class="na">SDK_INT</span> <span class="o">&lt;=</span> <span class="mi">15</span><span class="o">){</span></div><div class='line' id='LC177'>			<span class="k">try</span><span class="o">{</span></div><div class='line' id='LC178'>				<span class="n">playSound</span><span class="o">(</span><span class="k">this</span><span class="o">);</span></div><div class='line' id='LC179'>			<span class="o">}</span><span class="k">catch</span><span class="o">(</span><span class="n">Exception</span> <span class="n">e</span><span class="o">){</span></div><div class='line' id='LC180'>				<span class="n">Log</span><span class="o">.</span><span class="na">e</span><span class="o">(</span><span class="s">&quot;play sound&quot;</span><span class="o">,</span> <span class="n">e</span><span class="o">.</span><span class="na">getMessage</span><span class="o">());</span></div><div class='line' id='LC181'>			<span class="o">}</span></div><div class='line' id='LC182'>		<span class="o">}</span></div><div class='line' id='LC183'>	<span class="o">}</span></div><div class='line' id='LC184'><br/></div><div class='line' id='LC185'>	<span class="kd">public</span> <span class="kt">void</span> <span class="nf">playSound</span><span class="o">(</span><span class="n">Context</span> <span class="n">context</span><span class="o">)</span> <span class="kd">throws</span> <span class="n">IllegalArgumentException</span><span class="o">,</span> <span class="n">SecurityException</span><span class="o">,</span> <span class="n">IllegalStateException</span><span class="o">,</span> <span class="n">IOException</span> <span class="o">{</span></div><div class='line' id='LC186'><br/></div><div class='line' id='LC187'>		<span class="n">Uri</span> <span class="n">soundUri</span> <span class="o">=</span> <span class="n">RingtoneManager</span><span class="o">.</span><span class="na">getDefaultUri</span><span class="o">(</span><span class="n">RingtoneManager</span><span class="o">.</span><span class="na">TYPE_NOTIFICATION</span><span class="o">);</span></div><div class='line' id='LC188'>		<span class="n">MediaPlayer</span> <span class="n">mMediaPlayer</span> <span class="o">=</span> <span class="k">new</span> <span class="n">MediaPlayer</span><span class="o">();</span></div><div class='line' id='LC189'>		<span class="n">mMediaPlayer</span><span class="o">.</span><span class="na">setDataSource</span><span class="o">(</span><span class="n">context</span><span class="o">,</span> <span class="n">soundUri</span><span class="o">);</span></div><div class='line' id='LC190'>		<span class="kd">final</span> <span class="n">AudioManager</span> <span class="n">audioManager</span> <span class="o">=</span> <span class="o">(</span><span class="n">AudioManager</span><span class="o">)</span> <span class="n">context</span><span class="o">.</span><span class="na">getSystemService</span><span class="o">(</span><span class="n">Context</span><span class="o">.</span><span class="na">AUDIO_SERVICE</span><span class="o">);</span></div><div class='line' id='LC191'><br/></div><div class='line' id='LC192'>		<span class="k">if</span> <span class="o">(</span><span class="n">audioManager</span><span class="o">.</span><span class="na">getStreamVolume</span><span class="o">(</span><span class="n">AudioManager</span><span class="o">.</span><span class="na">STREAM_ALARM</span><span class="o">)</span> <span class="o">!=</span> <span class="mi">0</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC193'>			<span class="n">mMediaPlayer</span><span class="o">.</span><span class="na">setAudioStreamType</span><span class="o">(</span><span class="n">AudioManager</span><span class="o">.</span><span class="na">STREAM_ALARM</span><span class="o">);</span></div><div class='line' id='LC194'>			<span class="n">mMediaPlayer</span><span class="o">.</span><span class="na">setLooping</span><span class="o">(</span><span class="kc">false</span><span class="o">);</span></div><div class='line' id='LC195'>			<span class="n">mMediaPlayer</span><span class="o">.</span><span class="na">prepare</span><span class="o">();</span></div><div class='line' id='LC196'>			<span class="n">mMediaPlayer</span><span class="o">.</span><span class="na">start</span><span class="o">();</span></div><div class='line' id='LC197'>		<span class="o">}</span></div><div class='line' id='LC198'>	<span class="o">}</span></div><div class='line' id='LC199'><br/></div><div class='line' id='LC200'>	<span class="c1">//---------------- Speech Recognizer Listener Start --------------------------</span></div><div class='line' id='LC201'>		<span class="nd">@Override</span></div><div class='line' id='LC202'>		<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onReadyForSpeech</span><span class="o">(</span><span class="n">Bundle</span> <span class="n">params</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC203'>			<span class="n">Log</span><span class="o">.</span><span class="na">e</span><span class="o">(</span><span class="s">&quot;SPEECH RECOGNIZER&quot;</span><span class="o">,</span><span class="s">&quot;Recognize Ready&quot;</span><span class="o">);</span></div><div class='line' id='LC204'>		<span class="o">}</span></div><div class='line' id='LC205'><br/></div><div class='line' id='LC206'>		<span class="nd">@Override</span></div><div class='line' id='LC207'>		<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onBeginningOfSpeech</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC208'>			<span class="n">Log</span><span class="o">.</span><span class="na">e</span><span class="o">(</span><span class="s">&quot;SPEECH RECOGNIZER&quot;</span><span class="o">,</span><span class="s">&quot;Recognize Begin Speech&quot;</span><span class="o">);</span></div><div class='line' id='LC209'>		<span class="o">}</span></div><div class='line' id='LC210'><br/></div><div class='line' id='LC211'>		<span class="nd">@Override</span></div><div class='line' id='LC212'>		<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onRmsChanged</span><span class="o">(</span><span class="kt">float</span> <span class="n">rmsdB</span><span class="o">)</span> <span class="o">{</span>	<span class="o">}</span></div><div class='line' id='LC213'><br/></div><div class='line' id='LC214'>		<span class="nd">@Override</span></div><div class='line' id='LC215'>		<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onBufferReceived</span><span class="o">(</span><span class="kt">byte</span><span class="o">[]</span> <span class="n">buffer</span><span class="o">)</span> <span class="o">{</span> <span class="o">}</span></div><div class='line' id='LC216'><br/></div><div class='line' id='LC217'>		<span class="nd">@Override</span></div><div class='line' id='LC218'>		<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onEndOfSpeech</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC219'>			 <span class="n">Log</span><span class="o">.</span><span class="na">e</span><span class="o">(</span><span class="s">&quot;SPEECH RECOGNIZER&quot;</span><span class="o">,</span><span class="s">&quot;Recognize End Speech&quot;</span><span class="o">);</span></div><div class='line' id='LC220'>		<span class="o">}</span></div><div class='line' id='LC221'><br/></div><div class='line' id='LC222'>		<span class="nd">@Override</span></div><div class='line' id='LC223'>		<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onError</span><span class="o">(</span><span class="kt">int</span> <span class="n">error</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC224'>			<span class="n">Log</span><span class="o">.</span><span class="na">e</span><span class="o">(</span><span class="s">&quot;SPEECH RECOGNIZER&quot;</span><span class="o">,</span><span class="s">&quot;Recognize Error: &quot;</span><span class="o">+</span> <span class="n">error</span><span class="o">);</span></div><div class='line' id='LC225'>			<span class="k">if</span><span class="o">(</span><span class="n">error</span> <span class="o">==</span> <span class="mi">6</span><span class="o">){</span> <span class="c1">//speech recognizer timed out</span></div><div class='line' id='LC226'>				<span class="n">read</span><span class="o">();</span></div><div class='line' id='LC227'>			<span class="o">}</span></div><div class='line' id='LC228'>			<span class="k">if</span><span class="o">(</span><span class="n">error</span> <span class="o">==</span> <span class="mi">7</span><span class="o">){</span> <span class="c1">//no word match found</span></div><div class='line' id='LC229'>				<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;Sorry, I did not understand what you said. Please try again.&quot;</span><span class="o">);</span></div><div class='line' id='LC230'>		    	<span class="n">HashMap</span><span class="o">&lt;</span><span class="n">String</span><span class="o">,</span> <span class="n">String</span><span class="o">&gt;</span> <span class="n">hashTts</span> <span class="o">=</span> <span class="k">new</span> <span class="n">HashMap</span><span class="o">&lt;</span><span class="n">String</span><span class="o">,</span> <span class="n">String</span><span class="o">&gt;();</span></div><div class='line' id='LC231'>			    <span class="n">hashTts</span><span class="o">.</span><span class="na">put</span><span class="o">(</span><span class="n">TextToSpeech</span><span class="o">.</span><span class="na">Engine</span><span class="o">.</span><span class="na">KEY_PARAM_UTTERANCE_ID</span><span class="o">,</span> <span class="s">&quot;id&quot;</span><span class="o">);</span></div><div class='line' id='LC232'>			    <span class="n">tts</span><span class="o">.</span><span class="na">speak</span><span class="o">(</span><span class="s">&quot;Sorry, I did not understand what you said. Please try again.&quot;</span><span class="o">,</span> <span class="n">TextToSpeech</span><span class="o">.</span><span class="na">QUEUE_ADD</span><span class="o">,</span> <span class="n">hashTts</span><span class="o">);</span></div><div class='line' id='LC233'>			<span class="o">}</span></div><div class='line' id='LC234'>		<span class="o">}</span></div><div class='line' id='LC235'><br/></div><div class='line' id='LC236'>		<span class="nd">@Override</span></div><div class='line' id='LC237'>		<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onResults</span><span class="o">(</span><span class="n">Bundle</span> <span class="n">results</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC238'>			<span class="n">Log</span><span class="o">.</span><span class="na">e</span><span class="o">(</span><span class="s">&quot;SPEECH RECOGNIZER&quot;</span><span class="o">,</span><span class="s">&quot;Recognize onResults()&quot;</span><span class="o">);</span></div><div class='line' id='LC239'>			<span class="n">ArrayList</span><span class="o">&lt;</span><span class="n">String</span><span class="o">&gt;</span> <span class="n">data</span> <span class="o">=</span> <span class="n">results</span><span class="o">.</span><span class="na">getStringArrayList</span><span class="o">(</span><span class="n">SpeechRecognizer</span><span class="o">.</span><span class="na">RESULTS_RECOGNITION</span><span class="o">);</span></div><div class='line' id='LC240'>	        <span class="k">if</span> <span class="o">(</span><span class="n">data</span><span class="o">.</span><span class="na">size</span><span class="o">()</span> <span class="o">&gt;</span> <span class="mi">0</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC241'>	            <span class="k">for</span> <span class="o">(</span><span class="n">String</span> <span class="n">word</span> <span class="o">:</span> <span class="n">data</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC242'>	                <span class="k">if</span> <span class="o">(</span><span class="n">word</span><span class="o">.</span><span class="na">equals</span><span class="o">(</span><span class="s">&quot;yes&quot;</span><span class="o">))</span> <span class="o">{</span></div><div class='line' id='LC243'>	                    <span class="n">onClick</span><span class="o">(</span><span class="n">findViewById</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">id</span><span class="o">.</span><span class="na">bYes</span><span class="o">));</span></div><div class='line' id='LC244'>	                    <span class="k">return</span><span class="o">;</span></div><div class='line' id='LC245'>	                <span class="o">}</span> <span class="k">else</span> <span class="k">if</span> <span class="o">(</span><span class="n">word</span><span class="o">.</span><span class="na">equals</span><span class="o">(</span><span class="s">&quot;no&quot;</span><span class="o">))</span> <span class="o">{</span></div><div class='line' id='LC246'>	                    <span class="n">onClick</span><span class="o">(</span><span class="n">findViewById</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">id</span><span class="o">.</span><span class="na">bNo</span><span class="o">));</span></div><div class='line' id='LC247'>	                    <span class="k">return</span><span class="o">;</span></div><div class='line' id='LC248'>	                <span class="o">}</span></div><div class='line' id='LC249'>	            <span class="o">}</span></div><div class='line' id='LC250'>	            <span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;Sorry, &quot;</span> <span class="o">+</span> <span class="n">data</span><span class="o">.</span><span class="na">get</span><span class="o">(</span><span class="mi">0</span><span class="o">)</span> <span class="o">+</span> <span class="s">&quot; is not a valid command. Please try again.&quot;</span><span class="o">);</span></div><div class='line' id='LC251'>	        	<span class="n">HashMap</span><span class="o">&lt;</span><span class="n">String</span><span class="o">,</span> <span class="n">String</span><span class="o">&gt;</span> <span class="n">hashTts</span> <span class="o">=</span> <span class="k">new</span> <span class="n">HashMap</span><span class="o">&lt;</span><span class="n">String</span><span class="o">,</span> <span class="n">String</span><span class="o">&gt;();</span></div><div class='line' id='LC252'>	    	    <span class="n">hashTts</span><span class="o">.</span><span class="na">put</span><span class="o">(</span><span class="n">TextToSpeech</span><span class="o">.</span><span class="na">Engine</span><span class="o">.</span><span class="na">KEY_PARAM_UTTERANCE_ID</span><span class="o">,</span> <span class="s">&quot;id&quot;</span><span class="o">);</span></div><div class='line' id='LC253'>	    	    <span class="n">tts</span><span class="o">.</span><span class="na">speak</span><span class="o">(</span><span class="s">&quot;Sorry, &quot;</span> <span class="o">+</span> <span class="n">data</span><span class="o">.</span><span class="na">get</span><span class="o">(</span><span class="mi">0</span><span class="o">)</span> <span class="o">+</span> <span class="s">&quot; is not a valid command. Please try again.&quot;</span><span class="o">,</span> <span class="n">TextToSpeech</span><span class="o">.</span><span class="na">QUEUE_ADD</span><span class="o">,</span> <span class="n">hashTts</span><span class="o">);</span></div><div class='line' id='LC254'>	    	    <span class="k">return</span><span class="o">;</span></div><div class='line' id='LC255'>	        <span class="o">}</span></div><div class='line' id='LC256'><br/></div><div class='line' id='LC257'>		<span class="o">}</span></div><div class='line' id='LC258'><br/></div><div class='line' id='LC259'>		<span class="nd">@Override</span></div><div class='line' id='LC260'>		<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onPartialResults</span><span class="o">(</span><span class="n">Bundle</span> <span class="n">partialResults</span><span class="o">)</span> <span class="o">{</span> <span class="o">}</span></div><div class='line' id='LC261'><br/></div><div class='line' id='LC262'>		<span class="nd">@Override</span></div><div class='line' id='LC263'>		<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onEvent</span><span class="o">(</span><span class="kt">int</span> <span class="n">eventType</span><span class="o">,</span> <span class="n">Bundle</span> <span class="n">params</span><span class="o">)</span> <span class="o">{</span>	<span class="o">}</span></div><div class='line' id='LC264'><br/></div><div class='line' id='LC265'>		<span class="c1">//---------------- Speech Recognizer Listener End --------------------------</span></div><div class='line' id='LC266'><br/></div><div class='line' id='LC267'><span class="o">}</span></div></pre></div></td>
          </tr>
        </table>
  </div>

  </div>
</div>

<a href="#jump-to-line" rel="facebox[.linejump]" data-hotkey="l" class="js-jump-to-line" style="display:none">Jump to Line</a>
<div id="jump-to-line" style="display:none">
  <form accept-charset="UTF-8" class="js-jump-to-line-form">
    <input class="linejump-input js-jump-to-line-field" type="text" placeholder="Jump to line&hellip;" autofocus>
    <button type="submit" class="button">Go</button>
  </form>
</div>

        </div>

      </div><!-- /.repo-container -->
      <div class="modal-backdrop"></div>
    </div><!-- /.container -->
  </div><!-- /.site -->


    </div><!-- /.wrapper -->

      <div class="container">
  <div class="site-footer">
    <ul class="site-footer-links right">
      <li><a href="https://status.github.com/">Status</a></li>
      <li><a href="http://developer.github.com">API</a></li>
      <li><a href="http://training.github.com">Training</a></li>
      <li><a href="http://shop.github.com">Shop</a></li>
      <li><a href="/blog">Blog</a></li>
      <li><a href="/about">About</a></li>

    </ul>

    <a href="/">
      <span class="mega-octicon octicon-mark-github" title="GitHub"></span>
    </a>

    <ul class="site-footer-links">
      <li>&copy; 2014 <span title="0.02992s from github-fe140-cp1-prd.iad.github.net">GitHub</span>, Inc.</li>
        <li><a href="/site/terms">Terms</a></li>
        <li><a href="/site/privacy">Privacy</a></li>
        <li><a href="/security">Security</a></li>
        <li><a href="/contact">Contact</a></li>
    </ul>
  </div><!-- /.site-footer -->
</div><!-- /.container -->


    <div class="fullscreen-overlay js-fullscreen-overlay" id="fullscreen_overlay">
  <div class="fullscreen-container js-fullscreen-container">
    <div class="textarea-wrap">
      <textarea name="fullscreen-contents" id="fullscreen-contents" class="fullscreen-contents js-fullscreen-contents" placeholder="" data-suggester="fullscreen_suggester"></textarea>
    </div>
  </div>
  <div class="fullscreen-sidebar">
    <a href="#" class="exit-fullscreen js-exit-fullscreen tooltipped tooltipped-w" aria-label="Exit Zen Mode">
      <span class="mega-octicon octicon-screen-normal"></span>
    </a>
    <a href="#" class="theme-switcher js-theme-switcher tooltipped tooltipped-w"
      aria-label="Switch themes">
      <span class="octicon octicon-color-mode"></span>
    </a>
  </div>
</div>



    <div id="ajax-error-message" class="flash flash-error">
      <span class="octicon octicon-alert"></span>
      <a href="#" class="octicon octicon-remove-close close js-ajax-error-dismiss"></a>
      Something went wrong with that request. Please try again.
    </div>

  </body>
</html>


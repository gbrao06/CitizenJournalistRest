<!DOCTYPE HTML>
<!--
/*
 * JavaScript Load Image Demo 1.9.0
 * https://github.com/blueimp/JavaScript-Load-Image
 *
 * Copyright 2011, Sebastian Tschan
 * https://blueimp.net
 *
 * Licensed under the MIT license:
 * http://www.opensource.org/licenses/MIT
 */
-->
<html lang="en">
<head>
<!--[if IE]>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<![endif]-->
<meta charset="utf-8">
<title>JavaScript Load Image</title>
<meta name="description" content="JavaScript Load Image is a library to load images provided as File or Blob objects or via URL. It returns an optionally scaled and/or cropped HTML img or canvas element. It also provides a method to parse image meta data to extract Exif tags and thumbnails and to restore the complete image header after resizing.">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Jcrop is not required by JavaScript Load Image, but included for the demo -->
<link rel="stylesheet" href="css/vendor/jquery.Jcrop.css">
<link rel="stylesheet" href="css/demo.css">
</head>
<body>
<h1>JavaScript Load Image Demo</h1>
<p><a href="https://github.com/blueimp/JavaScript-Load-Image">JavaScript Load Image</a> is a library to load images provided as <a href="https://developer.mozilla.org/en/DOM/File">File</a> or <a href="https://developer.mozilla.org/en/DOM/Blob">Blob</a> objects or via URL.<br>
It returns an optionally <strong>scaled</strong> and/or <strong>cropped</strong> HTML <a href="https://developer.mozilla.org/en/docs/HTML/Element/Img">img</a> or <a href="https://developer.mozilla.org/en/docs/HTML/Canvas">canvas</a> element.<br>
It also provides a method to parse image meta data to extract <a href="http://en.wikipedia.org/wiki/Exif">Exif</a> tags and thumbnails and to restore the complete image header after resizing.</p>
<ul class="navigation">
    <li><a href="https://github.com/blueimp/JavaScript-Load-Image/tags">Download</a></li>
    <li><a href="https://github.com/blueimp/JavaScript-Load-Image">Source Code</a></li>
    <li><a href="https://github.com/blueimp/JavaScript-Load-Image/blob/master/README.md">Documentation</a></li>
    <li><a href="test/">Test</a></li>
    <li><a href="https://blueimp.net">&copy; Sebastian Tschan</a></li>
</ul>
<br>
<h2>Select an image file</h2>
<p><input type="file" id="file-input"></p>
<p>Or <strong>drag &amp; drop</strong> an image file onto this webpage.</p>
<br>
<h2>Result</h2>
<p id="actions" style="display:none;">
	<button type="button" id="edit">Edit</button>
	<button type="button" id="crop">Crop</button>
</p>
<div id="result" class="result">
    <p>This demo works only in browsers with support for the <a href="https://developer.mozilla.org/en/DOM/window.URL">URL</a> or <a href="https://developer.mozilla.org/en/DOM/FileReader">FileReader</a> API.</p>
</div>
<br>
<div id="exif" class="exif" style="display:none;">
    <h2>Exif meta data</h2>
    <p id="thumbnail" class="thumbnail" style="display:none;"></p>
    <table></table>
</div>
<br>
<script src="js/load-image.js"></script>
<script src="js/load-image-ios.js"></script>
<script src="js/load-image-orientation.js"></script>
<script src="js/load-image-meta.js"></script>
<script src="js/load-image-exif.js"></script>
<script src="js/load-image-exif-map.js"></script>
<!-- jQuery and Jcrop are not required by JavaScript Load Image, but included for the demo -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="js/vendor/jquery.Jcrop.js"></script>
<script src="js/demo.js"></script>
</body> 
</html>
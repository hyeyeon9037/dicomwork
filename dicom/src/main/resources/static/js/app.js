document.addEventListener('DOMContentLoaded', () => {
<<<<<<< HEAD
	// cornerston초기화
	cornerstoneWADOImageLoader.external.cornerstone = cornerstone;
	cornerstoneWADOImageLoader.external.cornerstoneTools = cornerstoneTools;
	
	// 이미지를 넣을 요소 얻어오기
	const element = document.getElementById('dicomImage');
	
	// 이미지 요소를 초기화
	cornerstone.enable(element);
	
	// 이미지 얻어오기
	const imageId = 'wadouri:img/MR.1.2.410.200013.1.510.1.20230207180200969.91652.dcm';
	
	cornerstone.loadImage(imageId).then(image => {
		cornerstone.displayImage(element, image);
	}).catch(err => {
		console.log('이미지 로드 실패 : ', err);
	});
	
	// 4.Add event handlers to flip or rotate the image
=======
   // 1. cornerston초기화
   cornerstoneWADOImageLoader.external.cornerstone = cornerstone;
   cornerstoneWADOImageLoader.external.cornerstoneTools = cornerstoneTools;
   
   // 이미지를 넣을 요소 얻어오기
   const element = document.getElementById('dicomImage');
   
   // 이미지 요소를 초기화
   cornerstone.enable(element);
   
   // 이미지 얻어오기
   const imageId = 'wadouri:img/MR.1.2.392.200036.9116.4.1.6116.40033.5.3001.1.1152393810.dcm';
   
   cornerstone.loadImage(imageId).then(image => {
      cornerstone.displayImage(element, image);
   }).catch(err => {
      console.log('이미지 로드 실패 : ', err);
   });
   
    // Add event handlers to flip or rotate the image
>>>>>>> dccc7c8e4e70d56944eeeae21a4c9682de7edff1
    document.getElementById('hFlip').addEventListener('click', function (e) {
        const viewport = cornerstone.getViewport(element);
        viewport.hflip = !viewport.hflip;
        cornerstone.setViewport(element, viewport);
    });

    document.getElementById('vFlip').addEventListener('click', function (e) {
        const viewport = cornerstone.getViewport(element);
        viewport.vflip = !viewport.vflip;
        cornerstone.setViewport(element, viewport);
    });

    document.getElementById('lRotate').addEventListener('click', function (e) {
        const viewport = cornerstone.getViewport(element);
        viewport.rotation-=90;
        cornerstone.setViewport(element, viewport);
    });

    document.getElementById('rRotate').addEventListener('click', function (e) {
        const viewport = cornerstone.getViewport(element);
        viewport.rotation+=90;
        cornerstone.setViewport(element, viewport);
    });

    document.getElementById('reset').addEventListener('click', function (e) {
        cornerstone.reset(element);
    });

    element.addEventListener('mousemove', function(event) {
        const pixelCoords = cornerstone.pageToPixel(element, event.pageX, event.pageY);
        document.getElementById('coords').textContent = "pageX=" + event.pageX + ", pageY=" + event.pageY + ", pixelX=" + pixelCoords.x + ", pixelY=" + pixelCoords.y;
    });
<<<<<<< HEAD
    

});
=======
});   
>>>>>>> dccc7c8e4e70d56944eeeae21a4c9682de7edff1

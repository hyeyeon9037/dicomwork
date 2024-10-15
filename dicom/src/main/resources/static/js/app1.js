document.addEventListener('DOMContentLoaded', () => {
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
});
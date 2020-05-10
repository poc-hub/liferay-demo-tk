import React from 'react'
import { Carousel } from 'react-responsive-carousel'

const IllustrationsCarousel = () => {
	return (
		<Carousel
			showIndicators={false}
			showThumbs={false}
			autoPlay={true}
			interval={7000}
			transitionTime={450}
			infiniteLoop={true}
			showStatus={false}
			useKeyboardArrows={true}
			emulateTouch={true}
			stopOnHover={false}
		>
			<div>
				<img src="/images/illustrations/liferay-dot-com/q3-2018/hero-analytics-cloud.png" />
			</div>
			<div>
				<img src="/images/illustrations/liferay-dot-com/q3-2018/hero-commerce.png" />
			</div>
			<div>
				<img src="/images/illustrations/liferay-dot-com/q3-2018/hero-dxp-cloud.png" />
			</div>
			<div>
				<img src="/images/illustrations/liferay-dot-com/q3-2018/hero-dxp.png" />
			</div>
			<div>
				<img src="/images/illustrations/liferay-dot-com/q3-2018/hero-homepage.png" />
			</div>
			<div>
				<img src="/images/illustrations/liferay-dot-com/q3-2018/hero-liferay-resources.png" />
			</div>
			<div>
				<img src="/images/illustrations/partner-portal/hero-marketing.png" />
			</div>
			<div>
				<img src="/images/illustrations/partner-portal/hero-login.png" />
			</div>
			<div>
				<img src="/images/illustrations/partner-portal/hero-sales.png" />
			</div>
			<div>
				<img src="/images/illustrations/partner-portal/hero-support.png" />
			</div>
			<div>
				<img src="/images/illustrations/partner-portal/hero-technical.jpg" />
			</div>
		</Carousel>
	)
}

export default IllustrationsCarousel

(this.webpackJsonpdebugcode=this.webpackJsonpdebugcode||[]).push([[0],{217:function(e,t,n){var o={".":40,"./":40,"./index":40,"./index.js":40};function s(e){var t=c(e);return n(t)}function c(e){if(!n.o(o,e)){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}return o[e]}s.keys=function(){return Object.keys(o)},s.resolve=c,e.exports=s,s.id=217},222:function(e,t,n){},223:function(e,t,n){},224:function(e,t,n){"use strict";n.r(t);n(96),n(133),n(197);var o=n(25),s=n(11),c=n(0),a=n(92),r=n(3),i=n(2),p=n(15);class d extends i.Page{render(){return Object(p.jsxs)("div",{children:[this.childComponents,this.childPages]})}}var m=Object(i.withModel)(d);class b extends o.ModelClient{fetch(e){if(!e){const t=`Fetching model rejected for path: ${e}`;return Promise.reject(new Error(t))}const t=this._apiHost||"";return fetch(`${t}${e}`,{credentials:"same-origin",headers:{Authorization:""}}).then((e=>e.status>=200&&e.status<300?e.json():Promise.reject(e))).catch((e=>Promise.reject(e)))}}var u=n(61),l=n.n(u);const g=()=>Object(p.jsx)("div",{children:"Error loading chunks!"}),h=(j=e=>Object(p.jsx)("div",{className:"loading-skeleton loading-skeleton__block",style:{height:e.skeletonHeight?e.skeletonHeight:"50px"}}),O={skeletonHeight:1e3},function(e){return Object(p.jsx)(j,{...O,...e})});var j,O;var E=function(e){let t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:h;return l()(e,{loading:t,error:g})};n(222);class y extends i.Page{get containerProps(){let e=super.containerProps;return e.className=(e.className||"")+" page "+(this.props.cssClassNames||""),e}}var M,T;Object(i.MapTo)("debugcode/components/page")(Object(i.withComponentMappingContext)((M=y,class extends c.Component{render(){let e=this.props.cqPath;return e?(T=T||"html",Object(p.jsx)(r.d,{exact:!0,path:"(.*)"+e+"(."+T+")?",render:e=>Object(p.jsx)(M,{...this.props,...e})},e)):Object(p.jsx)(M,{...this.props})}})));Object(i.MapTo)("debugcode/components/container")(Object(i.withComponentMappingContext)(i.AllowedComponentsContainer),{emptyLabel:"Container",isEmpty:function(e){return!e||!e.cqItemsOrder||0===e.cqItemsOrder.length}});Object(i.MapTo)("debugcode/components/experiencefragment")(Object(i.withComponentMappingContext)(i.Container),{emptyLabel:"Experience Fragment",isEmpty:function(e){return!e||!e.configured}});var x=n(93),C=n(94),V=n(33),I=n(8);const P=E((()=>Promise.all([n.e(3),n.e(4)]).then(n.bind(null,272)))),f=E((()=>n.e(5).then(n.t.bind(null,270,7)))),v=E((()=>n.e(6).then(n.t.bind(null,271,7))));Object(i.MapTo)("debugcode/components/download")(I.DownloadV1,{isEmpty:I.DownloadV1IsEmptyFn}),Object(i.MapTo)("debugcode/components/list")(I.ListV2,{isEmpty:I.ListV2IsEmptyFn}),Object(i.MapTo)("debugcode/components/separator")(I.SeparatorV1,{isEmpty:I.SeparatorV1IsEmptyFn}),Object(i.MapTo)("debugcode/components/button")(I.ButtonV1,{isEmpty:I.ButtonV1IsEmptyFn}),Object(i.MapTo)("debugcode/components/teaser")(I.TeaserV1,{isEmpty:I.TeaserV1IsEmptyFn}),Object(i.MapTo)("debugcode/components/image")(I.ImageV2,{isEmpty:I.ImageV2IsEmptyFn}),Object(i.MapTo)("debugcode/components/title")(f,{isEmpty:C.TitleV2IsEmptyFn}),Object(i.MapTo)("debugcode/components/breadcrumb")(I.BreadCrumbV2,{isEmpty:I.BreadCrumbV2IsEmptyFn}),Object(i.MapTo)("debugcode/components/navigation")(I.NavigationV1),Object(i.MapTo)("debugcode/components/languagenavigation")(I.LanguageNavigationV1),Object(i.MapTo)("debugcode/components/tabs")(V.TabsV1,{isEmpty:V.TabsV1IsEmptyFn}),Object(i.MapTo)("debugcode/components/accordion")(V.AccordionV1,{isEmpty:V.AccordionV1IsEmptyFn}),Object(i.MapTo)("debugcode/components/carousel")(v,{isEmpty:x.CarouselV1IsEmptyFn}),Object(i.MapTo)("debugcode/components/container")(V.ContainerV1,{isEmpty:V.ContainerV1IsEmptyFn});Object(i.MapTo)("debugcode/components/text")(P,{emptyLabel:"Text",isEmpty:function(e){return!e||!e.text||e.text.trim().length<1}});n(223);const w={};document.addEventListener("DOMContentLoaded",(()=>{o.ModelManager.initialize(w).then((e=>{const t=Object(s.a)();Object(a.render)(Object(p.jsx)(r.e,{history:t,children:Object(p.jsx)(m,{history:t,cqChildren:e[o.Constants.CHILDREN_PROP],cqItems:e[o.Constants.ITEMS_PROP],cqItemsOrder:e[o.Constants.ITEMS_ORDER_PROP],cqPath:e[o.Constants.PATH_PROP],locationPathname:window.location.pathname})}),document.getElementById("spa-root"))}))}))}},[[224,1,2]]]);
//# sourceMappingURL=main.6beb414c.chunk.js.map
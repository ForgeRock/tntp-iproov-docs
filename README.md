<h1 class="page">iProov Authentication node</h1>

<p>The <span class="label"><strong>iProov Authentication</strong></span> node integrates the iProov Genuine Presence
Assurance® (GPA) and Liveness Assurance™ (LA) directly from within your
authentication journey on Identity Cloud.</p>

<h2 id="compatibility"><a class="anchor" href="#compatibility"></a>Compatibility</h2>

<table class="tableblock frame-all grid-all fit-content">
<colgroup>
<col>
<col>
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Product</th>
<th class="tableblock halign-left valign-top">Compatible?</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">ForgeRock Identity Cloud</p></td>
<td class="tableblock halign-center valign-top"><p class="tableblock">Yes</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">ForgeRock Access Management (self-managed)</p></td>
<td class="tableblock halign-center valign-top"><p class="tableblock">Yes</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">ForgeRock Identity Platform (self-managed)</p></td>
<td class="tableblock halign-center valign-top"><p class="tableblock">Yes</p></td>
</tr>
</tbody>
</table>

## Inputs

A unique username is required in the shared state before the iProov Authentication node executes.

## Dependencies

<p>To use this node, you must configure your iProov tenant. Refer to <a href="auth-node-iproov-setup.html" class="xref page">Setting up the iProov tenant</a>.</p>

## Configuration

The configurable properties for this node are:

<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 20%;">
<col style="width: 80%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Property</th>
<th class="tableblock halign-left valign-top">Usage</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">iProov Tenant</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>The hostname of your iProov tenant, either <code>us.rp.secure.iproov.me</code>
or <code>eu.rp.secure.iproov.me</code>.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">iProov Base URL</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>The iProov URL context that contains the version of the REST API, which is
<code>/api/v2</code>.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">iProov API Key</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>The API key you obtained from iProov.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">iProov API Secret</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>The API secret from iProov.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">iProov OAuth Username</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>The username of the OAuth user on iProov.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">iProov OAuth Password</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>The password of the user on iProov.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">iProov Assurance Type</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>The type of API assurance on iProov:</p>
</div>
<div class="ulist">
<ul>
<li>
<p><code>GPA</code>: Generic Presence Assurance</p>
</li>
<li>
<p><code>LA</code>: Liveness Assurance</p>
<div class="paragraph">
<p>Default: <code>GPA</code>.</p>
</div>
</li>
</ul>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">iProov Authentication Type</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>The type of authentication. It can be one of:</p>
</div>
<div class="ulist">
<ul>
<li>
<p><code>Enrol</code> - for enrolling the user into iProov.</p>
</li>
<li>
<p><code>Verify</code> - for verifying the user’s liveness.</p>
</li>
<li>
<p><code>Combined</code> - for enrollment if the user is not enrolled, otherwise verify
the user’s liveness.</p>
<div class="paragraph">
<p>Default: <code>Enrol</code>.</p>
</div>
</li>
</ul>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">User Unique ID Attribute</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>The unique ID of the user enrolled with iProov. This attribute must exist in
the user’s AM profile in the identity repository.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">User Search Attributes</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>An alternative attribute that contains the username value, and is used to
search a user in the underlying identity store.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">ForgeRock UI</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>A boolean attribute for determining how the iProovWeb SDK is rendered to the
user.</p>
</div>
<div class="ulist">
<ul>
<li>
<p>When set to <code>true</code>, you can view the iProovWebSDK on the Identity Cloud admin UI.</p>
</li>
<li>
<p>When set to <code>false</code>, you can view the iProovWebSDK by going to <span class="label">Native Consoles &gt; Access Management</span>.</p>
<div class="paragraph">
<p>Default: <code>true</code>.</p>
</div>
</li>
</ul>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">iProov Version</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>The version of the iProov web SDK to use. Now 5.0.0 and 5.0.1 are supported.
Default: 5.0.0.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">Title Text Color</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>Adjusts the color of the title text above the central oval where the image is
captured. By default, no title is used. Refer to the
<a href="#custom-title">Custom Title</a> attribute for more information.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">Surround Color</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>Adjusts the color surrounding the central oval. It also affects the color of
the mask in Liveness Assurance with a <code>clear</code> or <code>blur</code> filter.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">Prompt Text Color</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>Adjusts the color of the text visible in the central prompt of the screen.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">Prompt Background Color</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>Adjusts the color of the background in the central prompt of the screen.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">Header Background Color</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>Adjusts the color of the background in the top bar of the application,
transparent by default.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><a id="custom-title"></a><span class="label">Custom Title</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>The title of the camera view that appears above the image area when the camera is capturing the image. Specify a custom title to be shown.
Default: An empty string ("").</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">Assets URL</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>Critical dependencies are loaded from the content delivery network (CDN) at
<code>cdn.iproov.app</code>. In a production environment, set this property to your CDN,
for example: https://cdn.iproov.app/<span class="var">myassets</span>.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">Logo</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>A relative link, absolute path or the data URI to your custom logo.
The logo can be in any web format, though it is recommended to use the SVG
format. If you don’t specify a logo, the iProov logo is displayed.
Set to <code>null</code> if you don’t want a logo to be displayed.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">Network Timeout</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>Time in seconds for the backend to acknowledge a message. If the timeout is
exceeded, Identity Cloud returns an error with the feedback code <code>error_network</code>.</p>
</div>
<div class="paragraph">
<p>Default: 20 (seconds).</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">iProov Camera Filter</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>Controls the filter for the camera preview. The value can be <span class="var">classic</span>,
<span class="var">shaded</span>, or <span class="var">vibrant</span>. For Liveness Assurance, two additional filters, <span class="var">clear</span> and <span class="var">blur</span>, are provided. The <span class="var">blur</span> filter is removed when the claim progresses.</p>
</div>
<div class="paragraph">
<p>+
Default: <span class="var">shaded</span>.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">Prompt Rounded Corners</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>The floating prompt has rounded corners by default. To disable rounded corners, set this attribute to <code>false</code>.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">Debug</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>By default, log messages at level <code>info</code> or lower are hidden. They can be
displayed on the console by setting <span class="label">Debug</span> to <code>true</code>. Log messages at
the <code>warning</code> and <code>error</code> levels are always displayed on the console.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">Slots</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>Customize the markup styling and automatically inherit your application’s
styles by using the <span class="label">Slots</span> attribute.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">Aria Live</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>Control the priority of messages being read out by the screen reader. Refer to
<a href="https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA/ARIA_Live_Regions">ARIA live regions</a> in Mozilla documentation for more information on ARIA live.
By default, this is set to <code>assertive</code> to indicate time-sensitive or critical
notifications that require the user’s immediate attention. This can be disabled by setting it to <code>off</code> or <code>polite</code>.</p>
</div></div></td>
</tr>
</tbody>
</table>

## Outputs

The following outputs are stored in the shared node state:

<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 20%;">
<col style="width: 80%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Output Variable</th>
<th class="tableblock halign-left valign-top">Variable Description</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">iProovValidateResponse</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>The complete validation response from iProov API in JSON format.</p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="label">iProoveValidatePhoto</span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p>Photo from the validated API endpoint response.</p>
</div></div></td>
</tr>
</tbody>
</table>

## Outcomes

<div class="dlist">
<dl>
<dt class="hdlist1"><code>Success</code></dt>
<dd>
<p>The iProov verification process is completed successfully.</p>
</dd>
<dt class="hdlist1"><code>Failure</code></dt>
<dd>
<p>The iProov verification process returned a failure because
a user connection or device failed during the verification process.</p>
</dd>
<dt class="hdlist1"><code>Retry</code></dt>
<dd>
<p>The iProov verification process is incomplete due to a failure or user error and can be retried.</p>
</dd>
<dt class="hdlist1"><code>Error</code></dt>
<dd>
<p>A fatal exception occurred due to misconfiguration or an error with the user account. Exceptions are logged at the Error level, and put in the SharedState.</p>
</dd>
<dt class="hdlist1"><code>Cancel</code></dt>
<dd>
<p>The user has opted to cancel the iProov verification.</p>
</dd>
</dl>
</div>

## Troubleshooting

If this node logs an error, review the log messages to find the reason for the error and address the issue appropriately.

## Examples

This example journey highlights the use of the <strong>iProov Authentication</strong> node to authenticate by using facial biometrics.

![img.png](img.png)

<p>Identity Cloud provides
<a href="https://github.com/ForgeRock/iproov-auth-tree-node/tree/master/sample">sample journeys you can download</a>
to understand and address the most common iProov authentication use cases.</p>
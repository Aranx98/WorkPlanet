import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/split-layout/src/vaadin-split-layout.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/crud/src/vaadin-crud.js';
import '@vaadin/message-list/src/vaadin-message-avatar.js';

@customElement('my-view')
export class MyView extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%;"></vaadin-horizontal-layout>
<vaadin-split-layout orientation="vertical" style="width: 100%; height: 100%;"></vaadin-split-layout>
<vaadin-vertical-layout theme="spacing" style="width: 100%; height: 100%;"></vaadin-vertical-layout>
<vaadin-button id="vaadinButton" style="height: 100%; width: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-s);">
 Button 
</vaadin-button>
<vaadin-crud></vaadin-crud>
<vaadin-message-avatar></vaadin-message-avatar>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}

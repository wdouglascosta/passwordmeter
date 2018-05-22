/* 
    Component created by capivara-cli https://capivarajs.github.io/
*/
import capivara from 'capivarajs';
import template from './component/pass-verifier.template.html';
import style from './component/pass-verifier.style.scss';
import { CapivaraPassVerifier } from './component/pass-verifier.component';

const Component = {
    /**
     * @name template
     * @description Applies the visual part of the component
     */
    template  : template,
    /**
     * @name style
     * @description Import component style
     */
    style     : style,
    /**
     * @name constants
     * @description Declares the constants that will be accepted by component. See https://capivarajs.github.io/components.html#constants
     */
    constants: [],
    /**
     * @name functions
     * @description Declares the functions that will be accepted by component. See https://capivarajs.github.io/components.html#functions
     */
    functions: [],
    /**
     * @name bindings
     * @description Declares the variables that will be accepted by component. See https://capivarajs.github.io/components.html#bindings
     */
    bindings: ['myParameter'],
    /**
     * @name controller
     * @description Sets the scope of the component
     */
    controller: CapivaraPassVerifier
};

export default capivara.component('cp-pass-verifier', Component);
import {AutoCrud} from "@hilla/react-crud";
import {EmployeeSolutionService} from "Frontend/generated/endpoints";
import EmployeeSolutionDTOModel from "Frontend/generated/com/example/application/solution/EmployeeSolutionDTOModel";
import Department from "Frontend/generated/com/example/application/Department";
import {useEffect, useState} from "react";
import {Select} from "@hilla/react-components/Select";

export default function SolutionView() {
    const [departments, setDepartments] = useState<Department[]>([]);
    const departmentOptions = departments.map(department => ({label: department.name, value: String(department.id)}));

    useEffect(() => {
        EmployeeSolutionService.listDepartments().then(setDepartments);
    }, []);

    return (
        <div className="p-m">
            <AutoCrud
                service={EmployeeSolutionService}
                model={EmployeeSolutionDTOModel}
                gridProps={{
                    visibleColumns: ['name', 'email', 'addressInfo', 'departmentName'],
                    columnOptions: {
                        addressInfo: {
                            filterable: false,
                            sortable: false
                        }
                    }
                }}
                formProps={{
                    visibleFields: ['name', 'email', 'address.street', 'address.city', 'departmentId'],
                    fieldOptions: {
                        departmentId: {
                            renderer({field}) {
                                return <Select items={departmentOptions} {...field} label="Department"/>;
                            }
                        }
                    }
                }}
            />
        </div>
    );
}
